package model;

import java.util.List;

import static controller.BaseballController.resultBallCountAndStrikeCount;
import static view.Input.inputBaseballNumbers;

public class GameOneRound {
    private static final int STRIKE = 1;
    private static final int BALL = 2;

    private int roundCount = 1;
    private Baseballs inputBaseballs;
    private final Baseballs systemBaseballs;
    private List<Integer> comparedResult;

    public GameOneRound(List<Baseball> uesrBaseballNumbers, List<Baseball> systemBaseballNumbers) {
        resetRoundCount();
        inputBaseballs = new Baseballs(uesrBaseballNumbers);
        systemBaseballs = new Baseballs(systemBaseballNumbers);
        comparedResult = inputBaseballs.compareThreeBall(systemBaseballs);
    }

    public void playOperation() {
        countUpRound();
        resultBallCountAndStrikeCount(countBallScore(), countStrike());
        inputBaseballs = enterNumbers();
        comparedResult = inputBaseballs.compareThreeBall(systemBaseballs);
    }

    public int getRoundCount() {
        return roundCount;
    }

    public boolean isThreeStrike() {
        return (int) comparedResult.stream()
                .filter(baseballResult -> baseballResult == STRIKE).count() == 3;
    }

    private Baseballs enterNumbers() {
        return new Baseballs(new InputNumbers(inputBaseballNumbers()).getInputBaseballNumbers());
    }

    private void countUpRound() {
        roundCount++;
    }

    private void resetRoundCount() {
        roundCount = 1;
    }

    private int countBallScore() {
        return (int) comparedResult.stream()
                .filter(baseballResult -> baseballResult == BALL)
                .count();
    }

    private int countStrike() {
        return (int) comparedResult.stream()
                .filter(baseballResult -> baseballResult == STRIKE)
                .count();
    }
}
