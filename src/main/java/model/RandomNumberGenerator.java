package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static util.RandomUtil.generateRandomNumber;

public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_SIZE = 3;
    private final Set<Integer> threeNumbers;

    public RandomNumberGenerator() {
        threeNumbers = new HashSet<>();

        while (threeNumbers.size() < RANDOM_NUMBER_SIZE) {
            threeNumbers.add(generateRandomNumber());
        }
    }

    public int[] getRandomNumbers() {
        Integer[] randomNumbers = threeNumbers.toArray(new Integer[0]);
        return Arrays.stream(randomNumbers).mapToInt(Integer::intValue).toArray();
    }
}