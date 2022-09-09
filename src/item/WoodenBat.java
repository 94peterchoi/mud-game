package item;

import play.Damage;
import play.Experience;
import play.Level;

public class WoodenBat extends Sword{

    public WoodenBat() {
        this.qualifiedLevel = new Level(1, new Experience(0));
        this.name = "나무몽둥이";
        this.weight = 1.2;
        this.description = "나무로 된 몽둥이. 전사의 기본 무기";
        this.damage = new Damage(11);
    }

}
