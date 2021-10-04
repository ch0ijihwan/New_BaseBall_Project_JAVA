package controller;

import model.Baseballs;
import model.GameOneRound;
import model.RandomBaseballNumbersGenerator;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.*;

public class BaseballController {
    private RandomBaseballNumbersGenerator randomBaseballNumbers;
    private GameOneRound gameOneRound;

    BaseballController() {
        Baseballs inputNumbers = new Baseballs(inputBaseballNumbers());
        randomBaseballNumbers = new RandomBaseballNumbersGenerator();
        gameOneRound = new GameOneRound(inputNumbers, randomBaseballNumbers.getRandomBaseballNumbers());
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
