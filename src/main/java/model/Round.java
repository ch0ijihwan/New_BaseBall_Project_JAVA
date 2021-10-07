package model;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private TotalResult totalResult;
    private final List<BallStatus> comparedResult;
    private final List<Integer> result = new ArrayList<>();

    public Round(Baseballs uesrBaseballNumbers, Baseballs systemBaseballNumbers) {
        comparedResult = uesrBaseballNumbers.compareThreeBall(systemBaseballNumbers);
    }

    public List<Integer> judgeResult() {
        totalResult = new TotalResult(this.comparedResult);
        result.add(totalResult.countBallScore());
        result.add(totalResult.countStrikeScore());

        return result;
    }

    public boolean isThreeStrike() {
        totalResult = new TotalResult(comparedResult);
        return totalResult.isResultThreeStrike();
    }
}
