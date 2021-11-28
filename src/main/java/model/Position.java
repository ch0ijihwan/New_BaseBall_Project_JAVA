package model;

import java.util.Objects;

public class Position {
    private static final int MAX_BALL_NUMBER_RANGE = 3;
    private static final int MIN_BALL_NUMBER_RANGE = 1;
    private final int value;

    public Position(final int value) {
        validatePositionBoundary(value);
        this.value = value;
    }

    private void validatePositionBoundary(final int value) {
        if (value < MIN_BALL_NUMBER_RANGE || value > MAX_BALL_NUMBER_RANGE) {
            throw new IllegalArgumentException("공의 Position 이 1,2,3 의 숫자가 아닙니다.");
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
