package util;

public class DelayUtil {

    public static void delay(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
