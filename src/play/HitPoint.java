package play;

public class HitPoint {
    int hp;

    public HitPoint(int hp) {
        if (hp < 0) {
            this.hp = 0;
        }
        this.hp = hp;
    }

    public boolean isHpZero() {
        return hp == 0;
    }

    public void decreaseHp(int damage) {
        hp = hp - damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    @Override
    public String toString() {
        return "" + hp;
    }
}
