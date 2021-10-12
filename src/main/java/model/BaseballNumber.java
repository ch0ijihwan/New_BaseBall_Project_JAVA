package model;

import java.util.Objects;

public class BaseballNumber {
    private static final int MIN_NUMBER_BOUNDY = 1;
    private static final int MAX_NUMBER_BOUNDY = 9;
    private final int number;

    public BaseballNumber(int number) {
        isNumber(number);
        this.number = number;
    }

    private void isNumber(int number) {
        if (!(MIN_NUMBER_BOUNDY<= number && number <= MAX_NUMBER_BOUNDY)) {
            throw new IllegalArgumentException("1~9에 있는 숫자가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}