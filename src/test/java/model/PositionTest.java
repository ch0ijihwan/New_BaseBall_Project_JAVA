package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @ParameterizedTest
    @DisplayName("0 ~ 2 사이에 있지 않은 포지션을  예외처리를 반환함을 확인하는 테스트 코드.")
    @CsvSource(value = {"-1", "3"})
    void validateRangeOfNumber(String value) {
        //given
        int actual = Integer.parseInt(value);
        //then
        assertThatThrownBy(() -> new Position(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("포지선의 범위가 0~2 사이가 아닙니다.");
    }

    @Test
    @DisplayName(" value()메서드 호출시,생성자에서 부터 받은 Postion을 제대로 반환하는지 확인하는 테스트 코드.")
    void value()
    {
        //given
        int expect = 0;
        Position position = new Position(expect);

        //when
        int actual = position.value();

        //then
        assertThat(actual).isEqualTo(expect);
    }

}