package controller;

import model.Balls;
import model.RandomBallNumbersGenerator;
import model.Round;

import static view.Input.inputBaseballNumbers;
import static view.StatusDisplay.showBallAndStrike;
import static view.StatusDisplay.showEndGame;

public class RoundController {
    private final Round round;

    public RoundController() {
        Balls userBaseballs = new Balls(inputBaseballNumbers());
        Balls systemBaseballs = new Balls(new RandomBallNumbersGenerator().getRandomBallNumber());
        round = new Round(userBaseballs, systemBaseballs);
    }

    public void playRound(){
        while (!round.isThreeStrike()){
            showBallAndStrike(round.countBall(),round.countStrike());
            Balls newUserBaseballs = new Balls(inputBaseballNumbers());
            round.inputNewBaseballs(newUserBaseballs);
        }
        showEndGame();
    }

    public static void showRoundResult( int ballCount, int strikeCount){
        showBallAndStrike(ballCount,strikeCount);
    }
}
