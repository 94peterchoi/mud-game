import entity.Character;
import item.AluminumBat;
import job.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import play.*;
import item.Sword;
import item.WoodenBat;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterTest {

    @BeforeEach
    void 플레이어_정보_초기화() {
        Character characterInstance = Character.getCharacterInstance();
        characterInstance.initializePlayer();
    }

    @Test
    void 플레이어_몬스터사냥후_레벨업_테스트() {
        // given
        Character jenny = Character.getCharacterInstance();
        assertEquals(jenny.getLevel(), new Level(1, new Experience(LevelQualifiedExp.L1)));

        // when
//        jenny.faceMonster();
        jenny.winMonster(new Experience(7));

        // then
        assertEquals(jenny.getLevel(), new Level(2, new Experience(LevelQualifiedExp.L2)));
    }

    @Test
    void 플레이어_무기_장착_테스트() {
        // given
        AluminumBat aluminumBat = new AluminumBat();
        Character noviceComa = Character.getCharacterInstance();

        // then
        IllegalArgumentException illegalCategory = assertThrows(IllegalArgumentException.class, () -> {
            noviceComa.armWeapon(new WoodenBat());
        });
        assertTrue(illegalCategory.getMessage().contains("직업군"));


        // gvien
        Character warriorNoel = Character.getCharacterInstance();
        // when
        warriorNoel.decidePlayerClass(new Warrior());
        // then
        IllegalArgumentException illegalLevel = assertThrows(IllegalArgumentException.class, () -> {
            warriorNoel.armWeapon(aluminumBat);
        });
        assertTrue(illegalLevel.getMessage().contains("레벨"));


        // when
        warriorNoel.winMonster(new Experience(LevelQualifiedExp.L2));
        // then
        assertInstanceOf(Sword.class, warriorNoel.armWeapon(aluminumBat));
    }

    @Test
    void 플레이어_이름_설정() {

        // given
        Character player = Character.getCharacterInstance();

        // when
        player.decidePlayerName(new CreatureName("김잔디"));

        // then
        assertEquals(player.getCreatureName(), "김잔디");

        assertThrows(IllegalArgumentException.class, () -> {
            player.decidePlayerName(new CreatureName(""));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            player.decidePlayerName(new CreatureName("열글자이상의이름을입력해버림"));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            player.decidePlayerName(new CreatureName("금잔디★"));
        });

    }

    @Test
    void 플레이어_행동_결정() {

        Character noviceComa = Character.getCharacterInstance();


    }


}
