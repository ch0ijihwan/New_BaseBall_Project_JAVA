package controller;

import model.BaseballGame;
import model.InputNumbers;
import model.RandomBaseballNumbersGenerator;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.*;

public class BaseballController {
    private InputNumbers inputNumbers;
    private RandomBaseballNumbersGenerator randomBaseballNumbers;
    private BaseballGame round;

    BaseballController() {
        inputNumbers = new InputNumbers(inputBaseballNumbers());
        randomBaseballNumbers = new RandomBaseballNumbersGenerator();
        round = new BaseballGame(inputNumbers.getInputBaseballNumbers(), randomBaseballNumbers.getRandomBaseballNumbers());
    }

    public void playGame() {
        while (!round.isThreeStrike()) {
            showRoundCount(round.getRoundCount());
            round.playOperation();
        }
        showEndGame();
    }


    public static void resultBallCountAndStrikeCount(int ballCount, int strikeCount) {
        showBallAndStrike(ballCount, strikeCount);
    }
}
