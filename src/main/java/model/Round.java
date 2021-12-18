package model;

import java.util.List;

public class Round {
    private static final int THREE_STRIKE = 3;

    private final List<BallStatus> comparedResult;

    public Round(Balls userBalls, Balls systemBalls) {
        comparedResult = userBalls.compareThreeBall(systemBalls);
    }
    public boolean isThreeStrike(){
        return countStrike() == THREE_STRIKE;
    }

    public int countStrike() {
        return countStatus(BallStatus.STRIKE);
    }

    public int countBall() {
        return countStatus(BallStatus.BALL);
    }

    private int countStatus(BallStatus desiredStatus) {
        return (int) comparedResult.stream()
                .filter(ballStatus -> ballStatus == desiredStatus)
                .count();
    }
}
