package item;

import play.Damage;
import play.Experience;
import play.Level;
import play.LevelQualifiedExp;

public class AluminumBat extends Sword {

    public AluminumBat() {
        this.qualifiedLevel = new Level(2, new Experience(LevelQualifiedExp.L2));
        this.name = "알미늄배트";
        this.weight = 2.0;
        this.description = "알루미늄 빠따. 맞으면 굉장히 아프다";
        this.damage = new Damage(15);
    }
}
