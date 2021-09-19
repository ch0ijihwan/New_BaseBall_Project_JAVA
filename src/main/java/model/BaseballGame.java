package model;

import java.util.List;

import static controller.BaseballController.resultBallCountAndStrikeCount;
import static view.Input.inputBaseballNumbers;

public class BaseballGame {
    private static final int STRIKE = 1;
    private static final int BALL = 2;

    private int roundCount = 1;
    private List<Baseball> uesrNumbers;
    private Baseballs inputBaseballs;
    private Baseballs systemBaseballs;
    private List<Integer> comparedResult;

    public BaseballGame(List<Baseball> uesrBaseballNumbers, List<Baseball> systemBaseballNumbers) {
        resetRoundCount();
        inputBaseballs = new Baseballs(uesrBaseballNumbers);
        systemBaseballs = new Baseballs(systemBaseballNumbers);
        comparedResult = inputBaseballs.compareThreeBall(systemBaseballs);
    }

    public void playOperation() {
        countUpRound();
        resultBallCountAndStrikeCount(countBallScore(), countStrike());
        this.uesrNumbers = enterNumbers();
    }

    private List<Baseball> enterNumbers() {
        return new InputNumbers(inputBaseballNumbers()).getInputBaseballNumbers();
    }

    private void countUpRound() {
        roundCount++;
    }

    private void resetRoundCount() {
        roundCount = 1;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public boolean isOver() {
        if (isThreeStrike()) {
            return false;
        }
        return true;
    }

    private boolean isThreeStrike() {
        return comparedResult.stream()
                .filter(baseballResult -> baseballResult == STRIKE).count() == 3;
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
