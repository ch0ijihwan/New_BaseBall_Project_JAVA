package model;

import java.util.List;

public class Game {
    private static final int THREE_STRIKE = 3;
    private Baseballs systemBaseballs;
    private List<BallStatus> comparedResult;

    public Game(Baseballs userBaseballs, Baseballs systemBaseballs) {
        this.systemBaseballs = systemBaseballs;
        comparedResult = systemBaseballs.compareThreeBall(userBaseballs);
    }

    public boolean isThreeStrike() {
        return contStrikeStatus() == THREE_STRIKE;
    }

    public void inputNewBaseballs(Baseballs userBaseballs) {
        comparedResult = systemBaseballs.compareThreeBall(userBaseballs);
    }

    public int countBallStatus() {
        return countStatus(BallStatus.BALL);
    }

    public int getStrikeCount(){
        return countScore(BallStatus.STRIKE_STATUS);
    }

    private int countStatus(BallStatus desiredValue) {
        return (int) this.comparedResult.stream()
                .filter(baseballResult -> baseballResult == desiredValue)
                .count();
    }
}
