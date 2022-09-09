package battle;

import entity.Character;
import play.*;

import java.util.Map;

public class BuffSkill extends Skill {

    protected int period = 1;             // 0은 영구버프, 1이상은 소멸버프
    protected int endTime;

    public void buffStat() {
//        Stats stats = Character.getCharacterInstance().getStats();
//        Stat stat = stats.getStats().get(StatCategory.STR);
//
//        stat.increaseStat(100);
    }

    @Override
    public void doEffect() {

    }

    public void clearBuff() {

    }

    public boolean isBuffPeriodEnd(int round) {
        if (round == this.endTime) {
            clearBuff();
            return true;
        }
        return false;
    }

}
