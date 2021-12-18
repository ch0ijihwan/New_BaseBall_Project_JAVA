package controller;

import view.StatusDisplay;

import static view.Input.askNewRound;
import static view.StatusDisplay.showNewGameQuestion;

public class BaseballGameController {
    private boolean isGamePlay = true;
    public BaseballGameController(){
        while (isGamePlay) {
            StatusDisplay.showStartGame();
            RoundController roundController = new RoundController();
            roundController.playRound();
            showNewGameQuestion();
            isGamePlay = askNewRound();
        }
    }
}
