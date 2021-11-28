package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    private Position position;

    @Test
    @DisplayName("Position 객체 생성 시, 생성자의 파라미터로 부터 받은 값을 저장한다.")
    void createPosition() {
        //given
        int input = 1;
        int expect = 1;

        //when
        position = new Position(input);

        //then
        assertThat(position).isEqualTo(new Position(expect));
    }

    @ParameterizedTest
    @DisplayName("Position 객체 생성 시, 생성자의 파라미터로 부터 받은 값이 1,2,3 이 아니라면 예외처리를 반환한다.")
    @CsvSource(value = {"0", "4"})
    void validatePositionBoundary(int input) {
        //then
        assertThatThrownBy(() -> new Position(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 Position 이 1,2,3 의 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("getValue() 호출 시, Position 의 value 값을 반환한다.")
    void getValue() {
        //given
        int input = 1;
        int expect = 1;
        position = new Position(input);

        //when
        int actual = position.getValue();

        //then
        assertThat(actual).isEqualTo(expect);
    }
}