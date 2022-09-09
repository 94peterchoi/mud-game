package play;

import java.util.ArrayList;
import java.util.List;

public class Skills {
    List<Skill> skills = new ArrayList<>();

    public void learn(List<Skill> learnableSkills) {
        for (Skill learnableSkill : learnableSkills) {
            if (isAlreadyLearned(learnableSkill)) {
                continue;
            }
            skills.add(learnableSkill);
            System.out.println("새로운 스킬(" + learnableSkill.getName() + ")을 배웠습니다.");
        }
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public boolean isAlreadyLearned(Skill skill) {
        return skills.contains(skill);
    }

    @Override
    public String toString() {
        String mySkills = "";
        for (Skill skill : skills) {
            mySkills += skill.getName() + " ";
        }
        return mySkills;
    }
}
