package controller;

import model.Baseballs;
import model.RandomBaseballNumbersGenerator;
import model.Round;

import java.util.List;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.showBallAndStrike;
import static view.StatusDisplay.showEndGame;

public class BaseballController {
    private Round round;
    private Baseballs inputBaseballNumbers;
    private final Baseballs systemBaseballNumbers;

    BaseballController() {
        inputBaseballNumbers = new Baseballs(inputBaseballNumbers());
        systemBaseballNumbers = new Baseballs (new RandomBaseballNumbersGenerator().getRandomBaseballNumbers());
        round = new Round(inputBaseballNumbers, systemBaseballNumbers);
    }

    public void playGame() {
        while (!round.isThreeStrike()) {
            resultBallCountAndStrikeCount(round.judgeResult());
            inputBaseballNumbers = new Baseballs(inputBaseballNumbers());
            round = new Round(inputBaseballNumbers,systemBaseballNumbers);
        }
        showEndGame();
    }


    public static void resultBallCountAndStrikeCount(int ballCount, int strikeCount) {
        showBallAndStrike(ballCount, strikeCount);
    }
}
