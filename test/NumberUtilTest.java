import org.junit.jupiter.api.Test;
import util.NumberUtil;
import static org.junit.jupiter.api.Assertions.*;


public class NumberUtilTest {

    @Test
    void 난수생성_테스트() {
        for (int i = 0; i < 100; i++) {
            assertTrue(() -> 1 <= NumberUtil.getRandomNumber() && NumberUtil.getRandomNumber() <= 10);
        }
    }

}
