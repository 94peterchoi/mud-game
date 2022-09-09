package play;

import battle.BattleInfo;
import job.ClassCategory;
import util.DelayUtil;

public class Skill implements Cloneable{

    protected Command command;
    protected ClassCategory targetClass;
    protected CoolTime coolTime;
    protected String description;
    protected Level qualifiedLevel;   // 스킬 요구레벨
    protected Critical critical;  // 스킬 크리티컬
    protected String motion;
    protected String name;

    public Skill() {
        targetClass = ClassCategory.ALL;
        coolTime = new CoolTime(0);
        description = "스킬 설명";
        qualifiedLevel = new Level(1, new Experience(0));
        critical = new Critical();
    }

    public void doEffect() {

    }

    public void printMotion() {
        for (int i=0; i<motion.length(); i++) {
            System.out.print(motion.charAt(i));
            DelayUtil.delay(100);
        }
        System.out.print(" " + BattleInfo.getMonster().getShape());
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public Level getQualifiedLevel() {
        return qualifiedLevel;
    }

    public CoolTime getCoolTime() {
        return coolTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Skill)) {
            return false;
        }

        Skill skill = (Skill) o;

        return name != null ? name.equals(skill.name) : skill.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public Object clone() {
        //CloneNotSupportedException 처리
        try {
            return super.clone();
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
