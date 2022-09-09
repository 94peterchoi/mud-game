package play;

public class Damage {

    public int damage;

    public Damage(int damage) {
        damageValidCheck(damage);
        this.damage = damage;
    }

    public void damageValidCheck(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("데미지는 0보다 작을 수 없습니다.");
        }
    }

    public int getDamage() {
        return damage;
    }
}
