package controller;

import model.GameOneRound;
import model.InputNumbers;
import model.RandomBaseballNumbersGenerator;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.*;

public class BaseballController {
    private InputNumbers inputNumbers;
    private RandomBaseballNumbersGenerator randomBaseballNumbers;
    private GameOneRound gameOneRound;

    BaseballController() {
        inputNumbers = new InputNumbers(inputBaseballNumbers());
        randomBaseballNumbers = new RandomBaseballNumbersGenerator();
        gameOneRound = new GameOneRound(inputNumbers.getInputBaseballNumbers(), randomBaseballNumbers.getRandomBaseballNumbers());
    }

    public void playGame() {
        while (!gameOneRound.isThreeStrike()) {
            showRoundCount(gameOneRound.getRoundCount());
            gameOneRound.nextTimeOperation();
        }
        showEndGame();
    }


    public static void resultBallCountAndStrikeCount(int ballCount, int strikeCount) {
        showBallAndStrike(ballCount, strikeCount);
    }
}
