package job;

import play.Level;
import play.Skill;
import play.StatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JobClass {

    protected List<Skill> learnableSkills = new ArrayList<>();

    ClassCategory classCategory;
    StatCategory mainStat;

    public ClassCategory getClassCategory() {
        return classCategory;
    }

    public StatCategory getMainStat() {
        return mainStat;
    }

    public List<Skill> checkLearnableSkill(Level playerLevel) {
        return learnableSkills.stream()
                .filter(skill -> playerLevel.isQualifiedLevel(skill.getQualifiedLevel()))
                .collect(Collectors.toList());
    }

    public void registerAllLearnableSkills() {

    }

    @Override
    public String toString() {
        return classCategory.toString();
    }
}
