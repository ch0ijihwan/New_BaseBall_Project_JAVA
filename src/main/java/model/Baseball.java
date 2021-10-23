package model;

import model.vo.BaseballNumber;
import model.vo.Position;

public class Baseball {
    private final BaseballNumber number;
    private final Position position;

    public Baseball(int baseBallNumber, int position) {
        this.number = new BaseballNumber(baseBallNumber);
        this.position = new Position(position);
    }

    public BallStatus judgeBallStatus(Baseball anotherBall) {
        if (this.number.equals(anotherBall.number) && this.position.equals(anotherBall.position)) {
            return BallStatus.STRIKE;
        }
        if (this.number.equals(anotherBall.number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
