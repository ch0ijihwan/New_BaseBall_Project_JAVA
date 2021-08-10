package model.score;

import model.BaseballNumber;

import java.util.List;
import java.util.stream.IntStream;

public class Strike {
    private Strike() {

    }

    private static final int NUMBER_LENGTH = 3;
    private static final int START = 0;

    public static int countStrike(List<BaseballNumber> inputNumbers, List<BaseballNumber> randomNumbers) {
        return (int) IntStream.range(START, NUMBER_LENGTH)
                .filter(index -> inputNumbers.toArray()[index].equals(randomNumbers.toArray()[index])).count();
    }
}
