package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DtoInputNumbersTest {
    DtoInputNumbers dtoInputNumbers;

    @ParameterizedTest
    @CsvSource(value = {"12", "1234"})
    @DisplayName("생성자에서 새로운 숫자야구 넘버를 받을 때, 올바르지 않은 값을 받은경우 (입력값이 세자리가 아닌경우) 예외 처리를 하는지 확인")
    void validateNumber(String value) {
        //give
        String[] tokens = value.split("");

        //when
        String[] actual = tokens;

        //then
        assertThatThrownBy(() -> dtoInputNumbers = new DtoInputNumbers(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 3자리가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"133", "999"})
    @DisplayName("생성자에서 새로운 숫자야구 넘버를 받을 때, 올바르지 않은 값을 받은경우 (중복된 수가 있는 경우) 예외 처리를 하는지 확인")
    void validateNumber2(String value) {
        //give
        String[] tokens = value.split("");

        //when
        String[] actual = tokens;

        //then
        assertThatThrownBy(() -> dtoInputNumbers = new DtoInputNumbers(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 수가 있습니다.");
    }
}