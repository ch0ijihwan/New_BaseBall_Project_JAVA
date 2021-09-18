package model;

import java.util.List;
import java.util.stream.Collectors;

public class Baseballs {
    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;
    private static final int NUMBER_OF_BASEBALLS = 3;

    private final List<Baseball> threeBalls;
    private int strikeCount;
    private int ballCount;

    public Baseballs(List<Baseball> threeBalls) {
        this.threeBalls = threeBalls;
    }
    private void compareThreeBall(Baseballs another) {
        return threeBalls.stream().map(another::compareBall).collect(Collectors.toList());
    }

    private Integer compareBall(Baseball anotherBalls) {
        return threeBalls.stream()
                .map(anotherBalls::checkBall)
                .filter(ballStatus -> ballStatus == BALL || ballStatus == STRIKE)
                .findAny()
                .orElse(NOTHING);
    }

}
