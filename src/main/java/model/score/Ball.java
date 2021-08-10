package model.score;

import model.Number;

import java.util.List;
import java.util.stream.IntStream;

public class Ball {
    private Ball() {

    }

    public static int countBall(List<Number> inputNumbers, List<Number> randomNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(index -> randomNumbers.contains(inputNumbers.get(index)))
                .filter(index -> !randomNumbers.get(index).equals(inputNumbers.get(index)))
                .count();
    }
}

