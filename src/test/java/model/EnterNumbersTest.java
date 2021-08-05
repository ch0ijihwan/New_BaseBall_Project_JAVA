package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EnterNumbersTest {
    @ParameterizedTest
    @CsvSource(value = {"1114", "11221", "12514", "32"})
    @DisplayName("세자리 수를 받지 않았을 때 예외처리 반환")
    void DuplicateCheckTest(String values) {
        String[] tokens = values.trim().split("");

        assertThatThrownBy(() -> new EnterNumbers(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 3자리가 아닙니다.");
    }
}