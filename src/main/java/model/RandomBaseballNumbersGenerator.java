package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.stream.IntStream;

import static util.RandomUtil.generateRandomNumber;

public class RandomBaseballNumbersGenerator {
    private static final int RANDOM_NUMBER_SIZE = 3;
    private final List<BaseballNumber> randomNumbers;

    public RandomBaseballNumbersGenerator() {
        Set<String> threeNumbers = new LinkedHashSet<>();
        while (threeNumbers.size() < RANDOM_NUMBER_SIZE) {
            threeNumbers.add(String.valueOf(generateRandomNumber()));
        }
        IntStream.range(0, RANDOM_NUMBER_SIZE).forEach(index -> randomBaseballs
                .add(new Baseball(new BaseballNumber(threeNumbers.pollFirst()), index)));
        return randomBaseballs;
    }
}