package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DtoInputNumbersTest {
    @Test
    @DisplayName("123 입력시, 생성자에서 입력받은 스트링 타입 배열을 인트형 배열로 변환하여 반환하는지 확인")
    void inputNumbers() {
        //given
        String[] input = new String[]{"1", "2", "3"};
        DtoInputNumbers dtoInputNumbers = new DtoInputNumbers(input);
        int[] expect = new int[]{1, 2, 3};

        //when
        int[] actual = dtoInputNumbers.getInputNumbers();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"12", "1234"})
    @DisplayName("생성자에서 새로운 숫자야구 넘버를 받을 때, 올바르지 않은 값을 받은경우 (입력값이 세자리가 아닌경우) 예외 처리를 하는지 확인")
    void validateNumberLength(String value) {
        //given
        String[] tokens = value.split("");

        //when
        String[] actual = tokens;

        //then
        assertThatThrownBy(() -> new DtoInputNumbers(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 3자리가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"133", "999"})
    @DisplayName("생성자에서 새로운 숫자야구 넘버를 받을 때, 올바르지 않은 값을 받은경우 (중복된 수가 있는 경우) 예외 처리를 하는지 확인")
    void validateOverlapNumber2(String value) {
        //given
        String[] tokens = value.split("");

        //when
        String[] actual = tokens;

        //then
        assertThatThrownBy(() -> new DtoInputNumbers(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 수가 있습니다.");
    }
}