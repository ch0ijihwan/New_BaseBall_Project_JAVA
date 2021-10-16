package model;

import model.vo.BaseballNumber;
import model.vo.Position;

public class Baseball {
    private final BaseballNumber number;
    private final Position position;

    public Baseball(BaseballNumber baseBallNumber, Position position) {
        this.number = baseBallNumber;
        this.position = position;
    }

    public Baseball(final int baseballNumber, final int position) {
        this(new BaseballNumber(baseballNumber), new Position(position));
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
