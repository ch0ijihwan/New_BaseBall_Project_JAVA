package controller;

import model.EnterNumbers;
import model.RandomBaseballNumbersGenerator;
import model.Round;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.*;

public class BaseballController {
    private EnterNumbers enteredNumbers;
    private RandomBaseballNumbersGenerator randomBaseballNumbers;
    private Round round;

    BaseballController() {
        enteredNumbers = new EnterNumbers(inputBaseballNumbers());
        randomBaseballNumbers = new RandomBaseballNumbersGenerator();
        round = new Round(enteredNumbers.getEnteredNumbers(), randomBaseballNumbers.getRandomBaseballNumbers());

    }

    public void playGame() {
        while (round.isOver()) {
            showRoundCount(round.getRoundCount());
            round.playRound();
        }
        showEndGame();
    }


    public static void resultBallCountAndStrikeCount(int ballCount, int strikeCount) {
        showBallAndStrike(ballCount, strikeCount);
    }
}
