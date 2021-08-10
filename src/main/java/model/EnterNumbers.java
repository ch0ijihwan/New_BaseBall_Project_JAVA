package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnterNumbers {
    private static final int NUMBER_LENGTH = 3;
    private final List<Number> values;

    public EnterNumbers(String[] tokens) {
        this.values = initValue(tokens);
    }

    private List<Number> initValue(String[] tokens) {
        checkEnteredNumber(tokens);
        return Arrays.stream(tokens)
                .map(Number::new).collect(Collectors.toList());
    }

    private void checkEnteredNumber(String[] token) {
        if (token.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
    }

    public List<Number> getEnteredNumbers() {
        return this.values;
    }
}
