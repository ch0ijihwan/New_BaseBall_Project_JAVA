package model;

import java.util.*;
import java.util.stream.IntStream;

import static util.RandomUtil.generateRandomNumber;

public class RandomBaseballsGenerator {
    private static final int RANDOM_NUMBER_SIZE = 3;
    private final Set<String> threeNumbers;

    public RandomBaseballsGenerator() {
        threeNumbers = new HashSet<>();

        while (threeNumbers.size() < RANDOM_NUMBER_SIZE) {
            threeNumbers.add(String.valueOf(generateRandomNumber()));
        }
    }

    public List<Baseball> getRandomBaseballs() {
        List<Baseball> randomBaseballs = new ArrayList<>();

        Iterator<String> iterThreeNumbers = threeNumbers.iterator();
        IntStream.range(0, RANDOM_NUMBER_SIZE).forEach(index -> randomBaseballs
                .add(new Baseball(new BaseballNumber(iterThreeNumbers.next()), index)));

        return randomBaseballs;
    }
}