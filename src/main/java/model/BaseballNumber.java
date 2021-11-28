package model;

import java.util.Objects;

public class BaseballNumber {
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