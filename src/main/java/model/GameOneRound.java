package model;

import java.util.List;

import static controller.BaseballController.resultBallCountAndStrikeCount;
import static view.Input.inputBaseballNumbers;

public class GameOneRound {
    private final Baseballs systemBaseballs;
    private TotalResult totalResult;
    private List<BallStatus> comparedResult;


    public GameOneRound(Baseballs uesrBaseballNumbers, List<Baseball> systemBaseballNumbers) {
        systemBaseballs = new Baseballs(systemBaseballNumbers);
        comparedResult = uesrBaseballNumbers.compareThreeBall(systemBaseballs);
    }

    public void operate() {
        totalResult = new TotalResult(comparedResult);
        resultBallCountAndStrikeCount(totalResult.countBallScore(), totalResult.countStrike());
        Baseballs inputNewBaseballs = enterNumbers();
        comparedResult = inputNewBaseballs.compareThreeBall(systemBaseballs);
    }

    public boolean isThreeStrike() {
       return totalResult.isResultThreeStrike();
    }

    private Baseballs enterNumbers() {
        return new Baseballs(inputBaseballNumbers());
    }
}
