package controller;

import view.StatusDisplay;

import static view.Input.askReplayGame;
import static view.StatusDisplay.showEndGame;
import static view.StatusDisplay.showNewGameQuestion;

public class GameController {
    private BaseballController baseBallController;
    private boolean isGamePlay = true;

    void run (){
        while (isGamePlay) {
            StatusDisplay.showStartGame();
            baseBallController.playGame();
            showEndGame();
            showNewGameQuestion();
            isGamePlay = askReplayGame();
        }
    }
}
