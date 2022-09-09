import entity.Character;
import item.WoodenBat;
import play.Scenario;

public class App {
    public static void main(String[] args) {
        System.out.println("머드 게임을 시작합니다.");

        Character player = Character.getCharacterInstance();
        Scenario scenario = Scenario.getScenarioInstance();

        scenario.getPlayerName();
        scenario.getPlayerClass();
        player.armWeapon(new WoodenBat());
        player.learnNewSkill();

        scenario.checkPlayerStatus();
    }
}
