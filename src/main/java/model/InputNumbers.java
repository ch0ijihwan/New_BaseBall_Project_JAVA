package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InputNumbers {
    private static final int NUMBER_LENGTH = 3;
    private final List<Baseball> values;

    public InputNumbers(String[] tokens) {
        validateNumber(tokens);
        values = new ArrayList<>();
        IntStream.range(0, NUMBER_LENGTH)
                .forEach(index -> values.add(new Baseball(new BaseballNumber(tokens[index]), index)));
    }

    private void validateNumber(String[] token) {
        if (token.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
    }

    public List<Baseball> getInputBaseballNumbers() {
        return this.values;
    }
}
