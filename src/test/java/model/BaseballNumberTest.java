package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
    private BaseballNumber number;
    private BaseballNumber anotherNumber;

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("생성자로부터 받은 받은 값이 1 ~ 9 사이에 있는 숫자가 아닌 경우 예외처리를 반환")
    void isNumber(int value) {
        assertThatThrownBy(() -> new BaseballNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9에 있는 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("오버라이드 한 이퀄즈 테스트 하는 테스트 코드")
    void EqualsWorkTest() {
        number = new BaseballNumber("1");
        assertThat(number.hashCode()).hasSameHashCodeAs(number.hashCode());
    }
}