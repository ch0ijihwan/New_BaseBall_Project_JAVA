package model;

import java.util.LinkedHashSet;
import java.util.Set;

import static model.score.Ball.countBall;
import static model.score.Strike.countStrike;
import static util.RandomUitl.generateRandomNumber;

public class RandomBaseballNumbers {
    private static final int RANDOM_NUMBER_SIZE = 3;
    private final Set<Number> threeNumbers = new LinkedHashSet<>();
    private final Set<Number> enterNumbers;

    public RandomBaseballNumbers(Set<Number> enteredNumbers) {
        while (threeNumbers.size() < RANDOM_NUMBER_SIZE) {
            threeNumbers.add(new Number(String.valueOf(generateRandomNumber())));
        }
        this.enterNumbers = enteredNumbers;
    }

    public Set<Number> getRandomBaseballNumbers() {
        return this.threeNumbers;
    }

    public int getBallCount() {
        return countBall(this.enterNumbers, this.getRandomBaseballNumbers());
    }

    public int getStrikeCount() {
        return countStrike(this.enterNumbers, this.getRandomBaseballNumbers());
    }
}