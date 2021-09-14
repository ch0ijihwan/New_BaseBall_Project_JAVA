package model;

import java.util.Objects;

public class BaseBall {
    private int number;
    private int position;

    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;

    public BaseBall(BaseballNumber baseBallNumber, int position) {
        this.number = baseBallNumber.value();
        this.position = position;
    }

    int checkBall(BaseBall anotherBall) {
        if (this.equals(anotherBall)) {
            return STRIKE;
        }
        if (this.number == anotherBall.number && this.position != anotherBall.position) {
            return BALL;
        }
        return NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBall baseBall = (BaseBall) o;
        return number == baseBall.number && position == baseBall.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
