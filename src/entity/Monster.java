package entity;

import exception.MonsterCreationException;
import monster.BossSnail;
import monster.GreenSnail;
import monster.RedSnail;
import play.Experience;
import play.HitPoint;
import play.Level;
import play.LevelQualifiedExp;
import util.NumberUtil;

public class Monster extends Creature {

    private static final int SERIAL_NUMBER_MIN = 1;
    private static final int SERIAL_NUMBER_MAX = 2;

    protected int serialNumber;
    protected String shape = "\uD83D\uDC0C";

    public Monster() {
        this.hp = new HitPoint(30);
    }

    public Monster create() {
        // 플레이어 레벨이 1인 경우 초록달팽이하고만 배틀
        if (Character.getCharacterInstance().getLevel().equals(new Level(1, new Experience(0.01)))) {
            return new GreenSnail();
        }
        // 플레이어 레벨이 2인 경우 빨간달팽이하고만 배틀
        if (Character.getCharacterInstance().getLevel().equals(new Level(2, new Experience(LevelQualifiedExp.L2)))) {
            return new RedSnail();
        }
        // 플레이어 레벨이 3 이상인 경우 보스달팽이하고만 배틀
        if (Character.getCharacterInstance().getLevel().isUpperLevel(new Level(3, new Experience(LevelQualifiedExp.L3)))) {
            return new BossSnail();
        }


        // 원래 실행되어야 하는 로직
        int serialNumber = NumberUtil.getMonsterSerialNumber(SERIAL_NUMBER_MAX);
        if (serialNumber == 1) {
            return new GreenSnail();
        }
        if (serialNumber == 2) {
            return new RedSnail();
        }
        if (serialNumber == 3) {
            return new BossSnail();
        }

        throw new MonsterCreationException();
    }

    public void attackPlayer() {
        System.out.println("몬스터 플레이어 공격!!");
    }

    public String getShape() {
        return shape;
    }

}
