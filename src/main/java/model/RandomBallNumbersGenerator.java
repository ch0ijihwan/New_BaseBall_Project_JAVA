package model;

import model.util.RandomUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomBallNumbersGenerator {
    private static final int BALLS_NUMBER_MAX_SIZE = 3;
    private final Set<Integer> threesNumbers = new HashSet<>();

    public RandomBallNumbersGenerator() {
        while (threesNumbers.size() < BALLS_NUMBER_MAX_SIZE) {
            threesNumbers.add(RandomUtil.generateRandomNumber());
        }
    }

    public List<Integer> getRandomBallNumber() {
        return threesNumbers.stream().collect(Collectors.toUnmodifiableList());
    }
}