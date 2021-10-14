package model.vo;

import java.util.Objects;

public class Position {
    private static final int MIN_BOUNDARY = 0;
    private static final int MAX_BOUNDARY = 2;
    private final int index;

    public Position(int index) {
        validateRangeOfNumber(index);
        this.index = index;
    }

    public int value() {
        return index;
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
        return index == position1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
