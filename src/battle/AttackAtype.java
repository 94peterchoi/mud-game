package battle;

import play.Damage;
import play.Stat;

public class AttackAtype implements AttackStrategy {

    private final double statRatio;
    private final double weaponRatio;

    public AttackAtype(double statRatio, double weaponRatio) {
        if (statRatio < 0 && weaponRatio < 0) {
            throw new IllegalArgumentException("무기와 스탯 데미지 비율은 음수가 될 수 없습니다.");
        }
        this.statRatio = statRatio;
        this.weaponRatio = weaponRatio;
    }

    @Override
    public Damage calcDamage(Stat stat, Damage damage) {
        return new Damage((int)(stat.getStat() * statRatio + damage.getDamage() * weaponRatio));
    }
}
