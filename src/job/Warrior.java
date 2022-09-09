package job;

import play.Level;
import play.Skill;
import play.StatCategory;
import skill.PowerStrike;
import skill.StormSmash;
import skill.ThirstForBlood;

import java.util.List;

public class Warrior extends JobClass {

    public Warrior() {
        classCategory = ClassCategory.WARRIOR;
        mainStat = StatCategory.STR;
    }

    @Override
    public void registerAllLearnableSkills() {
        learnableSkills.add(new PowerStrike());
        learnableSkills.add(new ThirstForBlood());
        learnableSkills.add(new StormSmash());
    }

    @Override
    public List<Skill> checkLearnableSkill(Level playerLevel) {
        return super.checkLearnableSkill(playerLevel);
    }
}
