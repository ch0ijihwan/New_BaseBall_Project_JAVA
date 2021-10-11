package model;

import java.util.List;

public class Round {
    private static final int THREE_STRIKE = 3;
    private Baseballs systemBaseballs;
    private List<BallStatus> comparedResult;

    public Round(Baseballs userBaseballs, Baseballs systemBaseballs) {
        this.systemBaseballs =  systemBaseballs;
        comparedResult = systemBaseballs.compareThreeBall(userBaseballs);
    }

    public boolean isThreeStrike() {
        return getStrikeCount() == THREE_STRIKE;
    }
    public void InputNewBaseballs(Baseballs userBaseballs){
        comparedResult = systemBaseballs.compareThreeBall(userBaseballs);
    }
    public int getBallCount() {
        return countScore(BallStatus.BALL_STATUS);
    }

    public int getStrikeCount(){
        return countScore(BallStatus.STRIKE_STATUS);
    }

    private int countScore(BallStatus desiredValue) {
        return (int) this.comparedResult.stream()
                .filter(baseballResult -> baseballResult == desiredValue)
                .count();
    }
}
