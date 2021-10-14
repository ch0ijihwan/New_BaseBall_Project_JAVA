package model;

public class Position {
    private static final int MIN_BOUNDARY = 0;
    private static final int MAX_BOUNDARY = 2;
    private int position;

    public Position(int position) {
        validateRangeOfNumber(position);
        this.position = position;
    }

    public int value() {
        return position;
    }

    private void validateRangeOfNumber(int position) {
        if (!(MIN_BOUNDARY <= position && position <= MAX_BOUNDARY)) {
            throw new IllegalArgumentException("포지선의 범위가 0~2 사이가 아닙니다.");
        }
    }

}
