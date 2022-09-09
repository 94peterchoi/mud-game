package play;

import java.util.HashMap;

public class Stats {

    HashMap<StatCategory, Stat> stats = new HashMap<>();
    private final int CHARACTER_BASIC_STAT = 4;

    public Stats() {
        stats.put(StatCategory.STR, new Stat(CHARACTER_BASIC_STAT));
        stats.put(StatCategory.WIT, new Stat(CHARACTER_BASIC_STAT));
        stats.put(StatCategory.DEX, new Stat(CHARACTER_BASIC_STAT));
    }

    public Stats(Stat str, Stat wit, Stat dex) {
        stats.put(StatCategory.STR, str);
        stats.put(StatCategory.WIT, wit);
        stats.put(StatCategory.DEX, dex);
    }

    public HashMap<StatCategory, Stat> getStats() {
        return stats;
    }

    public Stat getMainStat(StatCategory mainStat) {
        return stats.get(mainStat);
    }

    public void setStats(int level, StatCategory statCategory) {
        stats.put(statCategory, new Stat(CHARACTER_BASIC_STAT * level));
    }

    @Override
    public String toString() {
        Stat strStat = stats.get(StatCategory.STR);
        Stat dexStat = stats.get(StatCategory.DEX);
        Stat witStat = stats.get(StatCategory.WIT);
        return "힘: "  + strStat.getStat() + " 민첩: " + dexStat.getStat() + " 지혜: " + witStat.getStat() ;
    }
}
