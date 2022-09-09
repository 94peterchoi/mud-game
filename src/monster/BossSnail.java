package monster;

import entity.Character;
import play.CreatureName;
import play.Damage;
import play.Experience;
import play.HitPoint;
import util.DelayUtil;
import util.NumberUtil;

public class BossSnail extends Snail{

    private int basicDamage = 7;

    public BossSnail() {
        this.serialNumber = 3;
        this.name = new CreatureName("보스달팽이");
        this.exp = new Experience(50);
        this.hp = new HitPoint(150);
    }

    @Override
    public void attackPlayer() {
        int patternNumber = (int) (Math.random() * 3) + 1;

        if (patternNumber == 1 || patternNumber == 2) {
            useHeadButt();
        }
        if (patternNumber == 3) {
            useShellPowerUp();
        }
    }

    public void useHeadButt() {
        System.out.println(this.name + "의 몸통 박치기!");
        DelayUtil.delay(1000);
        Character.getCharacterInstance().beAttacked(new Damage(basicDamage));
    }

    public void useShellPowerUp() {
        System.out.println(this.name + "의 껍질 강화! ");
        this.basicDamage = this.basicDamage * 2;
        DelayUtil.delay(2000);
        System.out.println(this.name + "의 껍질이 2배 더 단단해졌다");
    }

}
