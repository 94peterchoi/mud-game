package play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 전역으로 사용할 필요가 있을지 검토해보기 (싱글톤?)
public class Levels {

    List<Level> levels = new ArrayList<>();
    private static final Levels levelsInstance = null;

    Experience level1Exp = new Experience(LevelQualifiedExp.L1);
    Experience level2Exp = new Experience(LevelQualifiedExp.L2);
    Experience level3Exp = new Experience(LevelQualifiedExp.L3);
    Experience level4Exp = new Experience(LevelQualifiedExp.L4);

    private Levels() {
        levels.add(new Level(1, level1Exp));
        levels.add(new Level(2, level2Exp));
        levels.add(new Level(3, level3Exp));
        levels.add(new Level(4, level4Exp));
    }

    public static Levels getLevelsInstance() {
        if (levelsInstance == null) {
            return new Levels();
        }
        return levelsInstance;
    }

    public Level getPlayerLevelByExp(Experience exp) {
        Level playerExperience = new Level(999, exp);
        levels.add(playerExperience);
        Collections.sort(this.levels);
        int index = this.levels.indexOf(playerExperience);
        levels.remove(index);

        return new Level(index, exp);
    }


}
