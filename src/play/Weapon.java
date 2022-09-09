package play;

import item.Item;
import job.ClassCategory;
import play.Damage;
import play.Experience;

public abstract class Weapon extends Item {

    protected Damage damage;              // 무기 데미지
    protected Stats stats;                // 무기 스텟
    protected ClassCategory targetClass;  // 요구직업군
    protected Level qualifiedLevel;       // 요구레벨

    public Weapon() {
        this.isWearable = true;
        this.isUseable = false;
        this.qualifiedLevel = new Level(1, new Experience(0));
        this.targetClass = ClassCategory.ALL;
    }

    // 해당 무기 착용 가능한 직업군인지 확인
    public boolean isRightTarget(ClassCategory playerClass) {
        if (targetClass.equals(ClassCategory.ALL)) {
            return true;
        }
        return targetClass.equals(playerClass);
    }

    // 해당 무기 착용 가능한 레벨인지 확인
    public boolean isRightLevel(Level playerLevel) {
        return playerLevel.isQualifiedLevel(qualifiedLevel);
    }

    public Damage getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return name;
    }
}
