package play;

public class Stat {

    int stat;

    public Stat(int stat) {
        statValidCheck(stat);
        this.stat = stat;
    }

    public void statValidCheck(int stat) {
        if (stat < 0) {
            throw new IllegalArgumentException("능력치는 0보다 작을 수 없습니다.");
        }
    }

    public int getStat() {
        return stat;
    }

    public void increaseStat(int stat) {
        statValidCheck(stat);
        this.stat += stat;
    }

    public void decreaseStat(int stat) {
        statValidCheck(stat);
        this.stat -= stat;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "stat=" + stat +
                '}';
    }
}
