package util;

public class NumberUtil {

    public static int getRandomNumber() {
        return (int)(Math.random()*3) + 1;
    }

    public static int getMonsterSerialNumber(int maxSerialNumber) {
        return (int)(Math.random() * maxSerialNumber) + 1;
    }

}
