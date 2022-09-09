package item;

import job.ClassCategory;
import play.*;

public class Sword extends Weapon {

    public Sword() {
        this.damage = new Damage(20);
        this.stats = new Stats(new Stat(10), new Stat(4), new Stat(4));
        this.qualifiedLevel = new Level(2, new Experience(5));
        this.targetClass = ClassCategory.WARRIOR;
    }

}
