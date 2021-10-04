package model;

public class Baseball {
    private final BaseballNumber number;
    private final int position;

    public Baseball(BaseballNumber baseBallNumber, int position) {
        number = baseBallNumber;
        this.position = position;
    }

    BallStatus checkBaseball(Baseball anotherBall) {
        if (this.number.equals(anotherBall.number) && this.position == anotherBall.position) {
            return BallStatus.STRIKE_STATUS;
        }
        if (this.number.equals(anotherBall.number)) {
            return BallStatus.BALL_STATUS;
        }
        return BallStatus.NOTHING_STATUS;
    }

    int getPosition() {
        return this.position;
    }
}
