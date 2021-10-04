package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputNumbersTest {
    private InputNumbers inputNumbers;

    @ParameterizedTest
    @CsvSource(value = {"123", "321", "492", "125", "319", "984", "582", "592", "182"})
    @DisplayName("숫자 세자리를 받았을 때, 이를 받아 리스트화하여 정상 작동하는지 확인하는 테스트 코드")
    void makeNumbers(String values) {
        String[] tokens = values.split("");
        inputNumbers = new InputNumbers(tokens);
        assertAll(
                () -> assertThat(inputNumbers.getInputBaseballNumbers().get(0).value())
                        .isEqualTo(Integer.parseInt(tokens[0])),
                () -> assertThat(inputNumbers.getInputBaseballNumbers().get(1).value())
                        .isEqualTo(Integer.parseInt(tokens[1])),
                () -> assertThat(inputNumbers.getInputBaseballNumbers().get(2).value())
                        .isEqualTo(Integer.parseInt(tokens[2]))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1114", "11221", "12514", "32"})
    @DisplayName("세자리 수를 받지 않았을 때 예외처리 반환")
    void duplicateCheckTest(String values) {
        String[] tokens = values.trim().split("");

        assertThatThrownBy(() -> new InputNumbers(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 3자리가 아닙니다.");
    }
}