package controller;

import model.EnterNumbers;
import model.RandomBaseballNumbers;

import static model.score.Strike.countStrike;
import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.showBallAndStrike;
import static view.StatusDisplay.showEndGame;

public class BaseballController {
    private EnterNumbers enteredNumbers;
    private final RandomBaseballNumbers randomBaseballNumbers;

    BaseballController() {
        enteredNumbers = new EnterNumbers(inputBaseballNumbers());
        randomBaseballNumbers = new RandomBaseballNumbers(enteredNumbers.getEnteredNumbers());
    }

    void playGame() {
        while (isThreeStrike()) {
            showBallAndStrike(randomBaseballNumbers.getBallCount(),randomBaseballNumbers.getStrikeCount());
            enterNumbers();
        }
        showEndGame();
    }

    void enterNumbers() {
        enteredNumbers = new EnterNumbers(inputBaseballNumbers());
    }

    boolean isThreeStrike() {
        return countStrike(enteredNumbers.getEnteredNumbers(), randomBaseballNumbers.getRandomBaseballNumbers()) != 3;
    }
}
