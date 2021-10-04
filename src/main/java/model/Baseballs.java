package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseballs {
    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;
    private static final int NUMBER_LENGTH = 3;

    private List<Baseball> threeBalls;

    public Baseballs(List<Baseball> threeBalls) {
        this.threeBalls = threeBalls;
    }

    public Baseballs(String[] inputNumbers) {
        validateNumber(inputNumbers);

        List<BaseballNumber> numbers;
        numbers = Arrays.stream(inputNumbers)
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        List<BaseballNumber> finalNumbers = numbers;
        IntStream.range(0,NUMBER_LENGTH)
                .forEach(position -> threeBalls.add(new Baseball(finalNumbers.get(position),position)));
    }

    private void validateNumber(String[] token) {
        if (token.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
        if (Arrays.stream(token).distinct().count() >= 2) {
            throw new IllegalArgumentException("중복되는 수가 있습니다.");
        }
    }

    public List<BallStatus> compareThreeBall(Baseballs another) {
        return threeBalls.stream()
                .map(another::compareBall)
                .collect(Collectors.toList());
    }

    private BallStatus compareBall(Baseball anotherBalls) {
        return threeBalls.stream()
                .map(anotherBalls::checkBaseball)
                .filter(ballStatus -> ballStatus == BallStatus.BALL_STATUS || ballStatus == BallStatus.STRIKE_STATUS)
                .findAny()
                .orElse(BallStatus.NOTHING_STATUS);
    }
}
