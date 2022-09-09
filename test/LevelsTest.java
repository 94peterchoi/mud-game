import org.junit.jupiter.api.Test;
import play.Experience;
import play.Level;
import play.LevelQualifiedExp;
import play.Levels;

import static org.junit.jupiter.api.Assertions.*;


class LevelsTest {

    @Test
    void 플레이어레벨_확인_테스트() {
        Level levelOne = new Level(1, new Experience(LevelQualifiedExp.L1));

        Levels levels = Levels.getLevelsInstance();
        Experience exp = new Experience(500);
        Level newLevel = levels.getPlayerLevelByExp(exp);

        assertEquals(newLevel.isSameLevel(levelOne), false);
    }

}