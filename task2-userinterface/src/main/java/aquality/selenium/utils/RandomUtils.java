package aquality.selenium.utils;

import java.util.Random;

public class RandomUtils {
    public static int getRandomInt(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }
}
