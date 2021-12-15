package model.ball;

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

    public static class BaseballNumber {
        private static final int MIN_NUMBER_BOUNDARY = 1;
        private static final int MAX_NUMBER_BOUNDARY = 9;
        private final int value;

        public BaseballNumber(final int value) {
            validateBaseballNumberBoundary(value);
            this.value = value;
        }

        private void validateBaseballNumberBoundary(final int value) {
            if (MIN_NUMBER_BOUNDARY > value || MAX_NUMBER_BOUNDARY < value) {
                throw new IllegalArgumentException("야구 숫자의 범위는 1 ~ 9 여야만 합니다.");
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BaseballNumber that = (BaseballNumber) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public static class Position {
        private static final int MAX_BALL_NUMBER_RANGE = 2;
        private static final int MIN_BALL_NUMBER_RANGE = 0;
        private final int value;

        public Position(final int value) {
            validatePositionBoundary(value);
            this.value = value;
        }

        private void validatePositionBoundary(final int value) {
            if (value < MIN_BALL_NUMBER_RANGE || value > MAX_BALL_NUMBER_RANGE) {
                throw new IllegalArgumentException("공의 Position 이 0,1,2 의 숫자가 아닙니다.");
            }
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return value == position.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "value=" + value +
                    '}';
        }
    }
}
