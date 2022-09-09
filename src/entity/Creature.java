package entity;

import play.*;

public class Creature {

    protected CreatureName name;
    Level level;
    protected HitPoint hp;
    protected Experience exp;
    Stats stats;

    public boolean beCreatureDead() {
        return hp.isHpZero();
    }

    public void beAttacked(Damage damage) {
        hp.decreaseHp(damage.getDamage());
        System.out.println(this.getCreatureName() + "(은/는) " + damage.getDamage() + "만큼의 피해를 입었다.");
        System.out.println();
    }

    public String getCreatureName() {
        return name.toString();
    }

    public Experience getExp() {
        return exp;
    }

    public HitPoint getHp() {
        return hp;
    }
}
