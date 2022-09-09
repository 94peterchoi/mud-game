package play;

public class Critical {

    private final int critical;

    public Critical() {
        this.critical = 100;
    }

    public Critical(int critical) {
        if (critical < 100 && 300 < critical) {
            throw new IllegalArgumentException("크리티컬은 1배~3배까지 설정 가능합니다.");
        }

        this.critical = critical;
    }
}
