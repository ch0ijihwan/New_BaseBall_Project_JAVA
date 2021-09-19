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
        if (this.number.equals(anotherBall.number) && this.position == anotherBall.position) {
            return STRIKE;
        }
        if (this.number.equals(anotherBall.number)) {
            return BALL;
        }
        return NOTHING;
    }

    int value() {
        return number.value();
    }
}
