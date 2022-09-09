package play;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillManagement {

    Map<String, Skill> skillMap = new HashMap<>();

    public SkillManagement() {

    }

    public SkillManagement(List<Skill> skills) {
        register(skills);
    }

    public void register(List<Skill> skills) {
        skills.forEach((skill -> skillMap.put(skill.command.getCommand(), skill)));
    }

    public Map<String, Skill> getSkillMap() {
        return skillMap;
    }

    public void adjustCoolTime() {
        skillMap.forEach((s, skill) -> {
            skill.getCoolTime().downCoolTime();
        });
    }

    public void initializeCoolTime() {
        skillMap.forEach((s, skill) -> {
            skill.getCoolTime().initialize();
        });
    }
}
