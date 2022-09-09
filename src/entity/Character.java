package entity;

import battle.BattleInfo;
import job.ClassCategory;
import job.JobClass;
import play.*;

import java.util.List;
import java.util.Map;

public class Character extends Creature {

    private static Character character = new Character();
    ClassCategory classCategory;
    CharacterStatus status;
    Weapon weapon;
    Skills skills;
    StatCategory mainStat;
    JobClass jobClass;

    private Character() {
        status = CharacterStatus.HERB;
        classCategory = ClassCategory.ALL;
        exp = new Experience(0.01);
        level = new Level(1, exp);
        hp = new HitPoint(100);
        stats = new Stats();
        skills = new Skills();
    }

    public static Character getCharacterInstance() {
        if (character == null) {
            character = new Character();
            return character;
        }
        return character;
    }

    public void initializePlayer() {
        status = CharacterStatus.HERB;
        classCategory = ClassCategory.ALL;
        exp = new Experience(0.01);
        level = new Level(1, exp);
        hp = new HitPoint(100);
        stats = new Stats();
    }

    public Weapon armWeapon(Weapon weapon) {
        if (!weapon.isRightTarget(this.classCategory)) {
            throw new IllegalArgumentException("해당 직업군은 사용 불가능한 무기입니다.");
        }
        if (!weapon.isRightLevel(this.level)) {
            throw new IllegalArgumentException("해당 무기를 착용할 수 있는 레벨이 아닙니다.");
        }
        this.weapon = weapon;
        return weapon;
    }

    // 몬스터가 등장하는 필드로 나선다
    public void goToField() {
        status = CharacterStatus.FIELD;
        Scenario.getScenarioInstance().walkAround();
    }

    // 몬스터와 마주침
    public void faceMonster() {
        status = CharacterStatus.BATTLE;
        // startBattle();
    }

    // 몬스터와의 배틀에서 이김
    // 지금은 몬스터 경험치만을 파라미터로 받고 있지만, 경험치 말고도 몬스터가 떨어뜨리는 장비를 습득할 수도 있으니
    // 파라미터로 entity.Monster 타입을 받는 게 맞을 듯
    public void winMonster(Experience monsterExp) {
        this.status = CharacterStatus.FIELD;
        this.exp.obtainExp(monsterExp);
        Level levelAfterBattle = Levels.getLevelsInstance().getPlayerLevelByExp(this.exp);

        // 플레이어의 레벨이 올랐다면
        if (level.isLevelUp(levelAfterBattle)) {
            level = levelAfterBattle;
            System.out.println("Level Up!! (현재 레벨: " + levelAfterBattle.getLevel() + ")");
            upgradeStats();
            learnNewSkill();
        }
    }

    public void useSkill(Skill skill) {
        if (skill == null) {
            throw new IllegalArgumentException("아직 배우지 않은 스킬입니다.");
        }
        if (skill.getCoolTime().isLeft()) {
            throw new IllegalArgumentException("쿨타임 도는 중");
        }
        skill.doEffect();
    }

    // 배틀에서 플레이어 행동 수행
    public void act(BattleInfo battleInfo) {

        PlayerAction playerAction = Scenario.getScenarioInstance().askPlayerAction();
        try {
            if (playerAction.equals(PlayerAction.USE_SKILL)) {
                Skill skill = Scenario.getScenarioInstance().askPlayerSkill(battleInfo.getSkillManagement().getSkillMap());
                useSkill(skill);
            }
            if (playerAction.equals(PlayerAction.USE_ITEM)) {
                // 인벤토리 열고
                // 아이템 사용
            }
            if (playerAction.equals(PlayerAction.RUN_AWAY)) {
                character.runAway();
            }
        } catch(IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            act(battleInfo);
        }
    }

    public void runAway() {
        status = CharacterStatus.FIELD;
    }

    // 레벨업 시 stat 증가시키기
    public void upgradeStats() {
        System.out.println("스탯이 증가하였습니다.");
        stats.setStats(level.getLevel(), mainStat);
    }

    public void recoverStats() {
        stats.setStats(level.getLevel(), mainStat);
    }

    /**
     *
     */
    public void learnNewSkill() {
        // 배울 수 있는 스킬이 있는지 확인
        List<Skill> learnableSkills = jobClass.checkLearnableSkill(level);

        if (learnableSkills == null) {
            System.out.println("배울 수 있는 스킬이 없습니다.");
            return;
        }
        skills.learn(learnableSkills);
    }

    public void recoverHp() {
        this.hp = new HitPoint(100);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Stats getStats() {
        return stats;
    }

    public StatCategory getMainStat() {
        return mainStat;
    }

    public Level getLevel() {
        return level;
    }

    public CharacterStatus getStatus() {
        return status;
    }

    public void decidePlayerName(CreatureName name) {
        this.name = name;
    }

    public void decidePlayerClass(JobClass jobClass) {
        this.jobClass = jobClass;
        this.classCategory = jobClass.getClassCategory();
        this.mainStat = jobClass.getMainStat();
        jobClass.registerAllLearnableSkills();
    }

    public void goToHerb() {
        status = CharacterStatus.HERB;
    }

    public void changeToBattle() {
        status = CharacterStatus.BATTLE;
    }

    public Skills getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "{이름=" + name.toString() +
                ", 착용무기=" + weapon.toString() +
                ", 보유기술=" + skills.toString() +
                ", 직업=" + jobClass.toString() +
                ", 레벨=" + level.toString() +
                ", hp=" + hp.toString() +
                ", 스텟=" + stats.toString() +
                '}';
    }

}
