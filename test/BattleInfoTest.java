import battle.BattleInfo;
import monster.RedSnail;
import monster.Snail;
import org.junit.jupiter.api.Test;

import java.util.Scanner;


public class BattleInfoTest {

    @Test
    void 배틀_턴_테스트() {
        BattleInfo battleInfo = new BattleInfo(new Snail());
    }

    @Test
    void 버프_해재_테스트() {
        BattleInfo battleInfo = new BattleInfo(new RedSnail());
        battleInfo.startBattle();
    }

    @Test
    void 입력() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(str);
    }



}
