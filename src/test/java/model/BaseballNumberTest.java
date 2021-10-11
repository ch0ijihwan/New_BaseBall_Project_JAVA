package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
    private BaseballNumber number;
    private BaseballNumber anotherNumber;

    @ParameterizedTest
    @ValueSource(strings = {"=", "+", "%", "a", "?", "0"})
    @DisplayName("받은 값이 1 ~ 9 숫자가 아닌 경우 예외처리를 반환")
    void isNumber(String value) {
        assertThatThrownBy(() -> new BaseballNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9에 있는 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("아무 값도 입력되지 않았을 경우 예외처리 반환")
    void isBlank(String empty) {
        assertThatThrownBy(() -> new BaseballNumber(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아무 값도 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("오버라이드 한 이퀄즈 테스트 하는 테스트 코드")
    void EqualsWorkTest() {
        number = new BaseballNumber("1");
        assertThat(number.hashCode()).hasSameHashCodeAs(number.hashCode());
    }
}