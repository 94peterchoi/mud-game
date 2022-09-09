package play;

import battle.BattleInfo;
import entity.Character;
import monster.GreenSnail;
import monster.RedSnail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import skill.PowerStrike;
import skill.ThirstForBlood;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class SkillsTest {

    @DisplayName("배틀 상황에서 스킬 등록 후 doEffect 실행")
    @Test
    void skillDoEffect() {

        // setUp
        new BattleInfo(new RedSnail());
        Character.getCharacterInstance();

        // given
        SkillManagement skills = new SkillManagement();

        List<Skill> playerSkills = new ArrayList<>();

        playerSkills.add(new PowerStrike());
        playerSkills.add(new ThirstForBlood());

        skills.register(playerSkills);

        Map<String, Skill> skillMap = skills.getSkillMap();
        Skill qSkill = skillMap.get("q");

        // when
        qSkill.doEffect();
    }

    @DisplayName("버프 중첩 확인")
    @Test
    void buffSkillTest() {
        BattleInfo battleInfo = new BattleInfo(new GreenSnail());
    }

}