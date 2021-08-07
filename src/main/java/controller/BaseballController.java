package controller;

import model.EnterNumbers;
import model.RandomBaseballNumbers;

import static model.score.Ball.countBall;
import static model.score.Strike.countStrike;
import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.showBallAndStrike;
import static view.StatusDisplay.showEndGame;

public class BaseballController {
    private EnterNumbers enteredNumbers;
    private RandomBaseballNumbers randomBaseballNumbers;

    BaseballController() {
        enteredNumbers = new EnterNumbers(inputBaseballNumbers());
        randomBaseballNumbers = new RandomBaseballNumbers();
    }

    void playGame() {
        while (isThreeStrike()) {
            showBallAndStrike(getBallCount(), getStrikeCount());
            enterNumbers();
        }
        showEndGame();
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
