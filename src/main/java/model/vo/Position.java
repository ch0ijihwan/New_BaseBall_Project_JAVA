package model.vo;

import java.util.Objects;

public class Position {
    private static final int MIN_BOUNDARY = 0;
    private static final int MAX_BOUNDARY = 2;
    private final int value;

    public Position(int value) {
        validateRangeOfNumber(value);
        this.value = value;
    }

    public int value() {
        return value;
    }

    private void validateRangeOfNumber(int position) {
        if (!(MIN_BOUNDARY <= position && position <= MAX_BOUNDARY)) {
            throw new IllegalArgumentException("공위치의 인덱스 범위가 0~2 사이가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
