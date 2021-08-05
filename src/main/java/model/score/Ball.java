package model.score;

import model.Number;

import java.util.Set;
import java.util.function.Predicate;

public class Ball {
    private Ball(){

    }
    public static int countBall(Set<Number> inputNumbers, Set<Number> randomNumbers) {

        return (int) (randomNumbers.stream()
                .filter(randomNumber -> inputNumbers.stream().anyMatch(Predicate.isEqual(randomNumber)))
                .count()
                - Strike.countStrike(inputNumbers, randomNumbers));
    }
}

