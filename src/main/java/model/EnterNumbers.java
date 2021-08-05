package model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnterNumbers {
    private final Set<Number> values;

    public EnterNumbers(String[] tokens) {
        this.values = initValue(tokens);
    }

    private Set<Number> initValue(String[] tokens) {
        checkEnteredNumber(tokens);
        return Arrays.stream(tokens)
                .map(Number::new)
                .collect(Collectors.toSet());
    }

    private void checkEnteredNumber(String[] token) {
        if (token.length != 3) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
    }

    public Set<Number> getEnteredNumbers() {
        return this.values;
    }
}
