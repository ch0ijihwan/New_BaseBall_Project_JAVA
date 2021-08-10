package model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static util.RandomUtil.generateRandomNumber;

public class RandomBaseballNumbers {
    private static final int RANDOM_NUMBER_SIZE = 3;
    private final List<BaseballNumber> randomNumbers;

    public RandomBaseballNumbers() {
        Set<String> threeNumbers = new LinkedHashSet<>();
        while (threeNumbers.size() < RANDOM_NUMBER_SIZE) {
            threeNumbers.add(String.valueOf(generateRandomNumber()));
        }
        randomNumbers = threeNumbers.stream().map(BaseballNumber::new).collect(Collectors.toList());
    }

    public List<BaseballNumber> getRandomBaseballNumbers() {
        return randomNumbers;
    }
}