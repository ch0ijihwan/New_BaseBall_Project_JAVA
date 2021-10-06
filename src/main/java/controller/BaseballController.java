package controller;

import model.Baseballs;
import model.GameOneRound;
import model.RandomBaseballNumbersGenerator;

import java.util.List;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.showBallAndStrike;
import static view.StatusDisplay.showEndGame;

public class BaseballController {
    private GameOneRound gameOneRound;
    private Baseballs inputBaseballNumbers;
    private final Baseballs systemBaseballNumbers;

    BaseballController() {
        inputBaseballNumbers = new Baseballs(inputBaseballNumbers());
        systemBaseballNumbers = new Baseballs (new RandomBaseballNumbersGenerator().getRandomBaseballNumbers());
        gameOneRound = new GameOneRound(inputBaseballNumbers, systemBaseballNumbers);
    }

    public void playGame() {
        while (!gameOneRound.isThreeStrike()) {
            resultBallCountAndStrikeCount(gameOneRound.operate());
            inputBaseballNumbers = new Baseballs(inputBaseballNumbers());
            gameOneRound = new GameOneRound(inputBaseballNumbers,systemBaseballNumbers);
        }
        showEndGame();
    }


    public static void resultBallCountAndStrikeCount(int ballCount, int strikeCount) {
        showBallAndStrike(ballCount, strikeCount);
    }
}
