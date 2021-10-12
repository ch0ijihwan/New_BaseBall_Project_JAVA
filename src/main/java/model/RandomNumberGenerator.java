package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.IntStream;

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
        int[] randomNumbers = new int[RANDOM_NUMBER_SIZE];
        Iterator<Integer> iterThreeNumbers = threeNumbers.iterator();

        IntStream.range(0, RANDOM_NUMBER_SIZE)
                .forEach(index -> randomNumbers[index] = iterThreeNumbers.next());

        return randomNumbers;
    }
}