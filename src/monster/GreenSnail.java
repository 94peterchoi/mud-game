package monster;

import battle.BattleInfo;
import entity.Character;
import play.CreatureName;
import play.Experience;
import play.HitPoint;
import play.LevelQualifiedExp;
import play.Damage;
import util.DelayUtil;

public class GreenSnail extends Snail {

    public GreenSnail() {
        this.serialNumber = 1;
        this.name = new CreatureName("초록달팽이");
        this.exp = new Experience(LevelQualifiedExp.L2);
        this.hp = new HitPoint(30);
    }

    @Override
    public void attackPlayer() {
        System.out.println("초록달팽이의 달팽이 껍질 날리기!");
        DelayUtil.delay(1000);
        Character.getCharacterInstance().beAttacked(new Damage(10));
    }

}
