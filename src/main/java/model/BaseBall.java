package model;

public class BaseBall {
    private int number;
    private int position;

    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;

    public BaseBall(BaseballNumber baseBallNumber, int position) {
        this.number = baseBallNumber.value();
        this.position = position;
    }

    int checkBall(BaseBall anotherBall) {
        if (this.number == anotherBall.number && this.position == anotherBall.position) {
            return STRIKE;
        }
        if (this.number == anotherBall.number && this.position != anotherBall.position) {
            return BALL;
        }
        return NOTHING;
    }
}
