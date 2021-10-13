package controller;

import model.Baseballs;
import model.DtoInputNumbers;
import model.Game;
import model.RandomNumberGenerator;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.showBallAndStrike;
import static view.StatusDisplay.showEndGame;

public class BaseballController {
    private final Game game;
    private DtoInputNumbers dtoInputNumbers;
    BaseballController() {
        inputBaseballNumbers = new Baseballs(inputBaseballNumbers());
        systemBaseballNumbers = new Baseballs(new RandomBaseballsGenerator().getRandomBaseballs());
    }

    public void playGame() {
        while (!game.isThreeStrike()) {
            showBallAndStrike(game.countBallStatus(), game.contStrikeStatus());
            dtoInputNumbers = new DtoInputNumbers(inputBaseballNumbers());
            Baseballs inputBaseballNumbers = new Baseballs(dtoInputNumbers.getInputNumbers());
            game.inputNewBaseballs(inputBaseballNumbers);
        }
        showEndGame();
    }


    public static void resultBallCountAndStrikeCount(int ballCount, int strikeCount) {
        showBallAndStrike(ballCount, strikeCount);
    }
}
