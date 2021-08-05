package model;

import java.util.LinkedHashSet;
import java.util.Set;

import static util.RandomUitl.generateRandomNumber;

public class RandomBaseballNumbers {
    private static final int RANDOM_NUMBER_SIZE = 3;
    private final Set<Number> threeNumbers = new LinkedHashSet<>();
    public RandomBaseballNumbers(){
        while (threeNumbers.size() < RANDOM_NUMBER_SIZE) {
            threeNumbers.add(new Number(String.valueOf(generateRandomNumber())));
        }
    }

    public Set<Number> getRandomBaseballNumbers() {
        return this.threeNumbers;
    }
}