package model;

public class Baseball {
    private final BaseballNumber number;
    private final Position position;

    public Baseball(BaseballNumber baseBallNumber, Position position) {
        this.number = baseBallNumber;
        this.position = position;
    }

    public BallStatus judgeBallStatus(Baseball anotherBall) {
        if (this.number.equals(anotherBall.number) && this.position.equals(anotherBall.position)) {
            return BallStatus.STRIKE;
        }
        if (this.number.equals(anotherBall.number)) {
            return BallStatus.BALL_STATUS;
        }
        return BallStatus.NOTHING;
    }
}
