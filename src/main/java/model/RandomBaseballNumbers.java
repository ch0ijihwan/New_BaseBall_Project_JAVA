package model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static util.RandomUtil.generateRandomNumber;

public class RandomBaseballNumbers {
    private static final int RANDOM_NUMBER_SIZE = 3;
    private final Set<String> threeNumbers = new LinkedHashSet<>();
    private final List<Number> randomNumbers;

    public RandomBaseballNumbers() {
        while (threeNumbers.size() < RANDOM_NUMBER_SIZE) {
            threeNumbers.add(String.valueOf(generateRandomNumber()));
        }
        randomNumbers = threeNumbers.stream().map(Number::new).collect(Collectors.toList());
    }

    public List<Number> getRandomBaseballNumbers() {
        return randomNumbers;
    }
}