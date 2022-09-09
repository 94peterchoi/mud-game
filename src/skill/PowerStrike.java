package skill;

import battle.AttackSkill;
import battle.AttackStrategy;
import play.Command;
import play.CoolTime;
import play.Experience;
import play.Level;
import util.DelayUtil;

public class PowerStrike extends AttackSkill {

    public PowerStrike() {
        this.name = "파워 스트라이크";
        this.qualifiedLevel = new Level(1, new Experience(0));
        coolTime = new CoolTime(0);
        this.command = new Command("q");
        this.description = "파워 스트라이크!!";
        this.motion = "▶>▶>▶>▶>";
    }

    public PowerStrike(AttackStrategy attackStrategy) {
        super(attackStrategy);
        new PowerStrike();
    }

    @Override
    public void doEffect() {
        System.out.println(description);

        DelayUtil.delay(700);
        printMotion();
        DelayUtil.delay(1000);

        super.doEffect();
    }

    public CoolTime getCoolTime() {
        return this.coolTime;
    }

}
