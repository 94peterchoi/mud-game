package battle;

import entity.Monster;
import play.CharacterStatus;
import play.Scenario;
import entity.Character;
import play.SkillManagement;
import play.Stats;

import java.util.*;

public class BattleInfo {

    static Monster monster;
    static int round = 1;
    static List<BuffSkill> playerBuffList;
    static Iterator<BuffSkill> playerBuffIter;
    Scenario scenario = Scenario.getScenarioInstance();
    Character player = Character.getCharacterInstance();
    SkillManagement skillManagement = new SkillManagement();

    public BattleInfo(Monster monster) {
        round = 1;
        playerBuffList = new ArrayList<>();
        BattleInfo.monster = monster;
        skillManagement.register(player.getSkills().getSkills());   // 컬렉션 포장이 잘못된 거 같아요 ..
    }

    public void startBattle() {
        player.changeToBattle();

        while(true) {
            boolean isBattleEnd = conductRound();
            if (isBattleEnd) {
                unmountPlayerBuffs();
                skillManagement.initializeCoolTime();
                Character.getCharacterInstance().recoverHp();
                break;
            }
        }

        scenario.checkPlayerStatus();
    }

    boolean conductRound() {
        player.act(this);
        if (monster.beCreatureDead()) {
            scenario.endBattle(monster);
            return true;
        }

        if (player.getStatus().equals(CharacterStatus.FIELD)) {
            scenario.endBattle(player);
            return true;
        }

        monster.attackPlayer();
        if (player.beCreatureDead()) {
            scenario.comeBackHerb();
            return true;
        }

        skillManagement.adjustCoolTime();

        round++;    // 다음라운드로 이동
        printHp();
        buffPeriodCheck();

        return false;
    }

    private void printHp() {
        System.out.println(player.getCreatureName() + " HP: " + player.getHp().toString());
        System.out.println(monster.getCreatureName() + " HP: " + monster.getHp().toString());
        System.out.println();
    }

    private void buffPeriodCheck() {
        playerBuffIter = playerBuffList.iterator();
        while (playerBuffIter.hasNext()) {
            BuffSkill buffSkill = playerBuffIter.next();
            if (buffSkill.isBuffPeriodEnd(this.round)) {
                System.out.println(buffSkill.getName() + " 종료");
                playerBuffIter.remove();
            }
        }

        if (playerBuffList.isEmpty()) {
            System.out.println("==" + player.getCreatureName() + "의 버프 목록==");
            System.out.println("버프 없음");
            return;
        }

        Set<BuffSkill> buffsLeft = new HashSet<>(playerBuffList);
        System.out.println();
        System.out.println("==" + player.getCreatureName() + "의 버프 목록==");

        for (BuffSkill buffSkill : buffsLeft) {
            System.out.println(buffSkill.toString());
        }
        System.out.println();
    }

    public static Monster getMonster() {
        return monster;
    }

    public static int getRound() {
        return round;
    }

    public static List<BuffSkill> getPlayerBuffList() {
        return playerBuffList;
    }

    public void unmountPlayerBuffs() {
        if (!playerBuffList.isEmpty()) {
            for (BuffSkill buffSkill : playerBuffList) {
                buffSkill.clearBuff();
            }
        }
    }

    public SkillManagement getSkillManagement() {
        return skillManagement;
    }
}
