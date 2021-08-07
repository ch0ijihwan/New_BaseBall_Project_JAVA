package controller;

import view.StatusDisplay;

import static view.Input.askReplayGame;
import static view.StatusDisplay.showNewGameQuestion;

public class GameController {
    private BaseballController baseBallController;
    private boolean isGamePlay = true;

    public void run() {
        while (isGamePlay) {
            StatusDisplay.showStartGame();
            baseBallController = new BaseballController();
            baseBallController.playGame();
            showNewGameQuestion();
            isGamePlay = askReplayGame();
        }
    }
}
