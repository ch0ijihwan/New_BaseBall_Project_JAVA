package controller;

import model.Baseballs;
import model.RandomBaseballNumbersGenerator;
import model.Round;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.showBallAndStrike;
import static view.StatusDisplay.showEndGame;

public class BaseballController {
    private Baseballs inputBaseballNumbers;
    private final Baseballs systemBaseballNumbers;

    BaseballController() {
        inputBaseballNumbers = new Baseballs(inputBaseballNumbers());
        systemBaseballNumbers = new Baseballs(new RandomBaseballNumbersGenerator().getRandomBaseballNumbers());
    }

    public void playGame() {
        Round round = new Round(inputBaseballNumbers, systemBaseballNumbers);
        while (!round.isThreeStrike()) {
            showBallAndStrike(round.getBallCount(), round.getStrikeCount());
            inputBaseballNumbers = new Baseballs(inputBaseballNumbers());
            round.InputNewBaseballs(inputBaseballNumbers);
        }
        showEndGame();
    }


    public static void resultBallCountAndStrikeCount(int ballCount, int strikeCount) {
        showBallAndStrike(ballCount, strikeCount);
    }
}
