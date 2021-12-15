package model.ball;

import model.BallStatus;
import model.ball.vo.BaseballNumber;
import model.ball.vo.Position;

import java.util.Objects;

public class Ball {
    private final BaseballNumber baseballNumber;
    private final Position position;

    public Ball(int inputtedBaseballNumber, int inputtedPosition) {
        this.baseballNumber = new BaseballNumber(inputtedBaseballNumber);
        this.position = new Position(inputtedPosition);
    }

    public BallStatus compareBallStatus(Ball anotherBall) {
        if (baseballNumber.equals(anotherBall.baseballNumber) && position.equals(anotherBall.position)) {
            return BallStatus.STRIKE;
        }
        if (baseballNumber.equals(anotherBall.baseballNumber) && !position.equals(anotherBall.position)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public int getBallPositionValue() {
        return position.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(baseballNumber, ball.baseballNumber) && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumber, position);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "baseballNumber=" + baseballNumber +
                ", position=" + position +
                '}';
    }
}
