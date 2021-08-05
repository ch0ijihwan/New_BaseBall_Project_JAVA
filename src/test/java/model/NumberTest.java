package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    private Number number;
    @ParameterizedTest
    @CsvSource(value = {"=", "+", "%", "a", "c", "?"})
    @DisplayName("받은 값이 숫자가 아닌경우 예외처리를 반환")
    void isNumber(String value) {
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9 사이의 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("아무 값도 입력되지 않았을 경우 예외처리 반환")
    void isBlank ()
    {
        assertThatThrownBy(() -> new Number(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아무 값도 입력되지 않았습니다.");
    }
}