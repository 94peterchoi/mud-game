package skill;

import battle.BattleInfo;
import battle.BuffSkill;
import entity.Character;
import play.*;
import util.DelayUtil;

public class ThirstForBlood extends BuffSkill {

    private final int buffAmount = 10;
    Stat stat;
    private static int nestedCount = 0;

    public ThirstForBlood() {
        this.name = "피의 갈망";
        this.qualifiedLevel = new Level(2, new Experience(LevelQualifiedExp.L2));
        this.coolTime = new CoolTime(0);
        this.command = new Command("w");
        this.period = 5;    // 지속시간
        this.description = "끓어오르는 피! (hp 8 사용)";
        this.motion = "\uD83E\uDE78\uD83E\uDE78\uD83E\uDE78\uD83E\uDE78\uD83E\uDE78\uD83E\uDE78\uD83E\uDE78\uD83E\uDE78";
    }

    @Override
    public void doEffect() {
        System.out.println(description);
        DelayUtil.delay(700);
        printMotion();
        DelayUtil.delay(1000);

        this.stat = Character.getCharacterInstance().getStats().getMainStat(Character.getCharacterInstance().getMainStat());
        this.buffStat();
        this.coolTime = new CoolTime(2);
        this.endTime = BattleInfo.getRound() + this.period;
        Character.getCharacterInstance().getHp().decreaseHp(8);

        BattleInfo.getPlayerBuffList().add((BuffSkill) this.clone());

        nestedCount++;
    }

    @Override
    public void buffStat() {
        stat.increaseStat(buffAmount);
        System.out.println(this.name +  " 효과로 힘이 " + buffAmount + "만큼 증가했다");
        System.out.println();
    }

    @Override
    public void clearBuff() {
        stat.decreaseStat(buffAmount);
        nestedCount--;
    }

    public static int getNestedCount() {
        return nestedCount;
    }

    @Override
    public void printMotion() {
        for (int i=0; i<motion.length(); i++) {
            System.out.print(motion.charAt(i));
            DelayUtil.delay(100);
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThirstForBlood)) return false;

        ThirstForBlood that = (ThirstForBlood) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return this.name + " " + nestedCount + "중첩";
    }

}
