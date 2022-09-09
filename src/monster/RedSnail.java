package monster;

import entity.Character;
import play.*;
import util.DelayUtil;

public class RedSnail extends Snail {

    public RedSnail() {
        this.serialNumber = 2;
        this.name = new CreatureName("빨간달팽이");
        this.exp = new Experience(LevelQualifiedExp.L3);
        this.hp = new HitPoint(80);
    }

    @Override
    public void attackPlayer() {
        System.out.println("빨간달팽이의 달팽이 껍질 날리기!");
        DelayUtil.delay(1000);
        Character.getCharacterInstance().beAttacked(new Damage(10));
    }

}
