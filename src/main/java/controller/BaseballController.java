package controller;

import model.EnterNumbers;
import model.RandomBaseballNumbers;
import model.Round;

import static model.score.Ball.countBall;
import static model.score.Strike.countStrike;
import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.*;

public class BaseballController {
    private EnterNumbers enteredNumbers;
    private RandomBaseballNumbers randomBaseballNumbers;
    private Round round = new Round();

    BaseballController() {
        enteredNumbers = new EnterNumbers(inputBaseballNumbers());
        randomBaseballNumbers = new RandomBaseballNumbers();
    }

    void playGame() {

        while (isThreeStrike()) {
            showRountCount(round.getRoundCount());
            showBallAndStrike(getBallCount(), getStrikeCount());
            enterNumbers();
            round.upRoundCount();
        }
        showEndGame();
        round.resetRoundCount();
    }

    void enterNumbers() {
        enteredNumbers = new EnterNumbers(inputBaseballNumbers());
    }

    int getBallCount() {
        return countBall(enteredNumbers.getEnteredNumbers(), randomBaseballNumbers.getRandomBaseballNumbers());
    }

    int getStrikeCount() {
        return countStrike(enteredNumbers.getEnteredNumbers(), randomBaseballNumbers.getRandomBaseballNumbers());
    }

    boolean isThreeStrike() {
        return countStrike(enteredNumbers.getEnteredNumbers(), randomBaseballNumbers.getRandomBaseballNumbers()) != 3;
    }
}
