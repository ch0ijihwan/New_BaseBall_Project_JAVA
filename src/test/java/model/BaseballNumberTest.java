package model;

import model.vo.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1","0"})
    @DisplayName("생성자로부터 받은 받은 값이 1 ~ 9 사이에 있는 숫자가 아닌 경우 예외처리를 반환")
    void isNumber(int value) {
        //then
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

    @ParameterizedTest
    @DisplayName("validateBaseballNumberBoundary() 호출 시, 파라미터로 부터 입력받은 야구 숫자에 대한 유효성 검사를 한다.")
    @CsvSource(value = {"0", "10"})
    void validateBaseballNumberBoundary(int input) {
        assertThatThrownBy(()->new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구 숫자의 범위는 1 ~ 9 여야만 합니다.");
    }
}