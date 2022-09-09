package skill;

import battle.AttackAtype;
import battle.AttackSkill;
import play.*;
import util.DelayUtil;

public class StormSmash extends AttackSkill {

    public StormSmash() {
        this.name = "스톰스매시";
        this.qualifiedLevel = new Level(3, new Experience(LevelQualifiedExp.L3));
        coolTime = new CoolTime(0);
        this.command = new Command("e");
        this.description = "스톰 스매시!!";
        this.motion = "\uD83C\uDF2A\uD83C\uDF2A\uD83C\uDF2A\uD83C\uDF2A\uD83C\uDF2A\uD83C\uDF2A\uD83C\uDF2A\uD83C\uDF2A";
        this.attackStrategy = new AttackAtype(3.0, 1.0);
    }

    @Override
    public void doEffect() {
        System.out.println(description);

        DelayUtil.delay(700);
        printMotion();
        DelayUtil.delay(1000);

        this.coolTime = new CoolTime(5);
        super.doEffect();
    }


}
