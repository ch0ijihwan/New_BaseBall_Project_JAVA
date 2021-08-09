package model;

public class Round {

    private int roundCount = 0;

    public void upRoundCount() {
        roundCount++;
    }

    public void resetRoundCount() {
        roundCount = 0;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
