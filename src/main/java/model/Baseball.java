package model;

public class Baseball {
    private final BaseballNumber number;
    private final int position;

    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;

    public Baseball(BaseballNumber baseBallNumber, int position) {
        number = baseBallNumber;
        this.position = position;
    }

    int checkBall(Baseball anotherBall) {
        if (this.equals(anotherBall)) {
            return STRIKE;
        }
        if (this.number == anotherBall.number) {
            return BALL;
        }
        return NOTHING;
    }
}
