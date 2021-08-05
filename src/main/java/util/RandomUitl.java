package util;

import java.util.Random;

public class RandomUitl {
    private RandomUitl(){

    }
    private static final int RANDOM_MAX_BOUNDARY = 9;
    private static final int RANDOM_START_BOUNDARY = 1;
    private static final Random RANDOM = new Random();

    public static int generateRandomNumber() {
        return RANDOM.nextInt(RANDOM_MAX_BOUNDARY) + RANDOM_START_BOUNDARY;
    }
}
