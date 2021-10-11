package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballsTest {
    private Baseballs baseballs;
    private Baseballs otherBaseballs;

    @ParameterizedTest
    @CsvSource(value = {"12", "1234"})
    @DisplayName("생성자에서 새로운 숫자야구 넘버를 받을 때, 올바르지 않은 값을 받은경우 (입력값이 세자리가 아닌경우) 예외 처리를 하는지 확인")
    void validateNumber(String value) {
        String[] tokens = value.split("");
        assertThatThrownBy(() -> baseballs = new Baseballs(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 3자리가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"133", "999"})
    @DisplayName("생성자에서 새로운 숫자야구 넘버를 받을 때, 올바르지 않은 값을 받은경우 (중복된 수가 있는 경우) 예외 처리를 하는지 확인")
    void validateNumber2(String value) {
        String[] tokens = value.split("");
        assertThatThrownBy(() -> baseballs = new Baseballs(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 수가 있습니다.");
    }

    @ParameterizedTest
    @MethodSource("createBaseballsParameterProvider")
    @DisplayName("새로운 숫자야구 넘버를 입력 받을 시 threeBalls 리스트를 생성하는지에 대한 테스트 코드")
    void makeBaseballs(String[] inputNumbers, Baseballs expect) {
        baseballs = new Baseballs(inputNumbers);
        assertAll(
                () -> assertThat(baseballs.compareThreeBall(expect).get(0)).isEqualTo(BallStatus.STRIKE_STATUS),
                () -> assertThat(baseballs.compareThreeBall(expect).get(1)).isEqualTo(BallStatus.STRIKE_STATUS),
                () -> assertThat(baseballs.compareThreeBall(expect).get(2)).isEqualTo(BallStatus.STRIKE_STATUS)
        );
    }

    static Stream<Arguments> createBaseballsParameterProvider() {
        return Stream.of(
                arguments(new String[]{"1", "2", "3"},
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2)))),
                arguments(new String[]{"5", "4", "8"},
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("5"), 0), new Baseball(new BaseballNumber("4"), 1), new Baseball(new BaseballNumber("8"), 2)))),
                arguments(new String[]{"9", "2", "5"},
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("9"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("5"), 2))))
        );
    }

    @Test
    @DisplayName("공을 세개씩 가진 두 야구공리스트을 비교하여, 그에대한 볼, 스트라이크, 낫씽을 리스트로 반환하는지 확인")
    void compareThreeBall() {

        Baseball firstBall = new Baseball(new BaseballNumber("1"), 0);
        Baseball secondBall = new Baseball(new BaseballNumber("2"), 1);
        Baseball thirdBall = new Baseball(new BaseballNumber("3"), 2);
        Baseball otherFirstBall = new Baseball(new BaseballNumber("1"), 0);
        Baseball otherSecondBall = new Baseball(new BaseballNumber("3"), 1);
        Baseball otherThirdBall = new Baseball(new BaseballNumber("8"), 2);

        baseballs = new Baseballs(Arrays.asList(firstBall, secondBall, thirdBall));
        otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        List<BallStatus> expect = Arrays.asList(BallStatus.STRIKE_STATUS, BallStatus.NOTHING_STATUS, BallStatus.BALL_STATUS);

        assertThat(baseballs.compareThreeBall(otherBaseballs)).isEqualTo(expect);
    }
}