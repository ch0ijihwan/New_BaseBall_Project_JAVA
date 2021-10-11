package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseballs {

    private static final int NUMBER_LENGTH = 3;

    private List<Baseball> threeBalls = new ArrayList<>();

    public Baseballs(List<Baseball> threeBalls) {
        this.threeBalls = threeBalls;
    }

    public Baseballs(String[] inputNumbers) {
        threeBalls  = new ArrayList<>();
        validateNumber(inputNumbers);

        IntStream.range(0, NUMBER_LENGTH)
                .forEach(position -> threeBalls.add(new Baseball(new BaseballNumber(inputNumbers[position]), position)));
    }

    private void validateNumber(String[] token) {
        if (token.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
        if (Arrays.stream(token).distinct().count() != 3) {
            throw new IllegalArgumentException("중복되는 수가 있습니다.");
        }
    }

    public List<BallStatus> compareThreeBall(Baseballs another) {
        return threeBalls.stream()
                .map(another::compareBall)
                .collect(Collectors.toList());
    }

    private BallStatus compareBall(Baseball anotherBall) {
        return threeBalls.stream()
                .map(anotherBall::checkBaseball)
                .filter(ballStatus -> ballStatus == BallStatus.BALL_STATUS || ballStatus == BallStatus.STRIKE_STATUS)
                .findAny()
                .orElse(BallStatus.NOTHING_STATUS);
    }
}
