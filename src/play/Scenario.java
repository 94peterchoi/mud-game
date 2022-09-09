package play;

import battle.BattleInfo;
import entity.Character;
import entity.Monster;
import job.Archer;
import job.Warrior;
import job.Wizard;
import util.DelayUtil;
import util.NumberUtil;

import java.util.Map;
import java.util.Scanner;

public class Scenario {

    private static final Scenario scenarioInstance = null;
    private static final Scanner scanner = new Scanner(System.in);
    private Character player = Character.getCharacterInstance();

    final int EXPECTED = 1;

    private Scenario() {

    }

    public static Scenario getScenarioInstance() {
        if (scenarioInstance == null) {
            return new Scenario();
        }
        return scenarioInstance;
    }

    public CreatureName getPlayerName() {
        System.out.println("이름을 입력하세요.");
        try {
            player.decidePlayerName(new CreatureName(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            getPlayerName();
        }
        return null;
    }

    public void getPlayerClass() {
        System.out.println("직업군을 입력하세요. (1-전사 2-법사 3-궁수)");
        String userInput = scanner.nextLine();
        try {
            if (userInput.equals("1")) {
                player.decidePlayerClass(new Warrior());
                return;
            }
            if (userInput.equals("2")) {
                throw new IllegalArgumentException("법사 - 미구현 직업입니다.");
//                player.decidePlayerClass(new Wizard());
//                return;
            }
            if (userInput.equals("3")) {
                throw new IllegalArgumentException("궁수 - 미구현 직업입니다.");
//                player.decidePlayerClass(new Archer());
//                return;
            }
            throw new IllegalArgumentException("잘못된 커맨드 입력입니다.");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            getPlayerClass();
        }
    }

    public PlayerAction askPlayerAction() {
        try {
            System.out.println("무엇을 하시겠습니까? 1. 싸운다 2. 도망친다");
            String actionNumber = scanner.nextLine();

            if (actionNumber.equals("1")) {
                return PlayerAction.USE_SKILL;
            }
            if (actionNumber.equals("2")) {
                return PlayerAction.RUN_AWAY;
            }
            throw new IllegalArgumentException("잘못된 행동 커맨드 입력입니다.");
        } catch(IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return askPlayerAction();
        }
    }

    public Skill askPlayerSkill(Map<String, Skill> skillMap) {
        System.out.print("[사용가능 스킬 목록] ");
        for (String key : skillMap.keySet()) {
            Skill skill = skillMap.get(key);
            if (skill.getCoolTime().isLeft()) {
                continue;
            }
            System.out.print(key + ": " + skill.getName() + " ");
        }
        System.out.println();

        String command = scanner.nextLine();
        Skill skill;

        if (command.equals("q")) {
            return skillMap.get("q");
        }
        if (command.equals("w")) {
            return skillMap.get("w");
        }
        if (command.equals("e")) {
            return skillMap.get("e");
        }

        throw new IllegalArgumentException("커맨드 입력 에러(등록되지 않은 스킬 커맨드)");
    }


    public void comeBackHerb() {
        System.out.println(player.getCreatureName() + "(이/가) " + BattleInfo.getMonster().getCreatureName() + "의 공격으로 사망하였습니다.");
        System.out.println("마을로 되돌아갑니다.");
        player.goToHerb();
    }

    public void endBattle(Monster monster) {
        System.out.println("플레이어는 " + monster.getCreatureName() + " (을/를) 물리쳤다!");
        System.out.println();
        player.winMonster(monster.getExp());
    }

    public void endBattle(Character player) {
        System.out.println(player.getCreatureName() + "(은/는) 성공적으로 도망쳤다..!");
    }

    public void checkPlayerStatus() {
        if (player.getStatus().equals(CharacterStatus.HERB)) {
            System.out.println("무엇을 하시겠습니까? 1. 필드로 나선다 2. 내 정보 확인 3. 아이템 장착");
            String command = scanner.nextLine();
            if (command.equals("1")) {
                player.goToField();
                return;
            }
            if (command.equals("2")) {
                System.out.println(player.toString());
                checkPlayerStatus();
            }
            if (command.equals("3")) {
                System.out.println("미구현 기능입니다.");
                checkPlayerStatus();
            }
            System.out.println("잘못된 커맨드를 입력하셨습니다.");
            checkPlayerStatus();
        }
        if (player.getStatus().equals(CharacterStatus.FIELD)) {
            System.out.println("무엇을 하시겠습니까? 1. 다시 필드를 거닌다. 2. 마을로 돌아간다.");
            String command = scanner.nextLine();
            if (command.equals("1")) {
                player.goToField();
                return;
            }
            if (command.equals("2")) {
                player.goToHerb();
                checkPlayerStatus();
            }
        }
        if (player.getStatus().equals(CharacterStatus.BATTLE)) {

        }
    }

    public void walkAround() {
        System.out.println("필드를 산책합니다.");
        while(true) {
            DelayUtil.delay(1000);
            System.out.println("필드를 거니는 중...");
            if (isMonsterPresent()) {
                break;
            }
        }
        Monster monster = new Monster().create();
        System.out.println(player.getCreatureName() + "(은/는) " + monster.getCreatureName() + "(을/를) 마주쳤다!\n");
        new BattleInfo(monster).startBattle();
    }

    private boolean isMonsterPresent() {
        return NumberUtil.getRandomNumber() == EXPECTED;
    }

}
