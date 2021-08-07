package model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EnterNumbers {
    private static final int NUMBER_LENGTH = 3;
    private final Set<Number> values;

    public EnterNumbers(String[] tokens) {
        this.values = initValue(tokens);
    }

    private Set<Number> initValue(String[] tokens) {
        checkEnteredNumber(tokens);
        return Arrays.stream(tokens)
                .map(Number::new).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private void checkEnteredNumber(String[] token) {
        if (token.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
    }

    public Set<Number> getEnteredNumbers() {
        return this.values;
    }
}
