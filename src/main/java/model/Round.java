package model;

import java.util.List;

import static controller.BaseballController.resultBallCountAndStrikeCount;
import static model.score.Ball.countBall;
import static model.score.Strike.countStrike;
import static view.Input.inputBaseballNumbers;

public class Round {

    private int roundCount = 1;
    private List<BaseballNumber> uesrNumbers;
    private final List<BaseballNumber> systemNumbers;

    public Round(List<BaseballNumber> uesrNumbers, List<BaseballNumber> systemNumbers) {
        this.uesrNumbers = uesrNumbers;
        this.systemNumbers = systemNumbers;
    }

    public void playRound() {
        upRoundCount();
        resultBallCountAndStrikeCount(resultBall(), resultStrike());
        if (isThreeStrike()) {
            isOver();
            resetRoundCount();
        }
        this.uesrNumbers = enterNumbers();
    }

    private List<BaseballNumber> enterNumbers() {
        return new EnterNumbers(inputBaseballNumbers()).getEnteredNumbers();
    }

    private void upRoundCount() {
        roundCount++;
    }

    private void resetRoundCount() {
        roundCount = 1;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public boolean isOver() {
        return !isThreeStrike();
    }

    private boolean isThreeStrike() {
        return countStrike(uesrNumbers, systemNumbers) == 3;
    }

    public int resultBall() {
        return countBall(uesrNumbers, systemNumbers);
    }

    public int resultStrike() {
        return countStrike(uesrNumbers, systemNumbers);
    }
}
