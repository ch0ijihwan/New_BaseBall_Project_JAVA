package model;

import java.util.List;

public class TotalResult {

    List<BallStatus> comparedResult;

    public TotalResult(List<BallStatus> comparedResult) {
        this.comparedResult = comparedResult;
    }

    public int countBallScore() {
        return (int) this.comparedResult.stream()
                .filter(baseballResult -> baseballResult == BallStatus.BALL_STATUS)
                .count();
    }

    public int countStrikeScore() {
        return (int) this.comparedResult.stream()
                .filter(baseballResult -> baseballResult == BallStatus.STRIKE_STATUS)
                .count();
    }

    public boolean isResultThreeStrike() {
        return countStrikeScore() == 3;
    }
}
