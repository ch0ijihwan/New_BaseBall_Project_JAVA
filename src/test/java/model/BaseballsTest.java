package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballsTest {
    private Baseballs baseballs;
    List<Baseball> threeBalls = new ArrayList<>();
    List<Baseball> otherThreeBalls = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Baseball firstBall = new Baseball(new BaseballNumber("1"), 0);
        Baseball secondBall = new Baseball(new BaseballNumber("2"), 1);
        Baseball thirdBall = new Baseball(new BaseballNumber("3"), 2);

        Baseball otherFirstBall = new Baseball(new BaseballNumber("1"), 0);
        Baseball otherSecondBall = new Baseball(new BaseballNumber("3"), 1);
        Baseball otherThirdBall = new Baseball(new BaseballNumber("8"), 2);

        threeBalls.add(firstBall);
        threeBalls.add(secondBall);
        threeBalls.add(thirdBall);

        otherThreeBalls.add(otherFirstBall);
        otherThreeBalls.add(otherSecondBall);
        otherThreeBalls.add(otherThirdBall);
    }

    @ParameterizedTest
    @CsvSource(value = {"1235", "4512", "1234", "7658", "3758"})
    @DisplayName("생성자에서 새로운 숫자야구 넘버를 받을 때, 올바르지 않은 값을 받은경우 (입력값이 세자리가 아닌경우) 예외 처리를 하는지 확인")
    void validateNumber(String value) {
        String[] tokens = value.split("");
        assertThatThrownBy(() -> baseballs = new Baseballs(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 3자리가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"133", "454", "121", "155", "338", "992"})
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
    @DisplayName("공을 세개씩 가진 두 야구공을 비교하여, 그에대한 볼, 스트라이크, 낫씽을 리스트로 반환하는지 확인")
    void compareThreeBall() {
        baseballs = new Baseballs(threeBalls);
        Baseballs otherBaseballs = new Baseballs(otherThreeBalls);
        List<BallStatus> expect = new ArrayList<>();
        expect.add(BallStatus.STRIKE_STATUS);
        expect.add(BallStatus.NOTHING_STATUS);
        expect.add(BallStatus.BALL_STATUS);

        assertThat(baseballs.compareThreeBall(otherBaseballs)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("baseballParameterProvider")
    @DisplayName("서로 다른 공 두개를 서로 비교하여 볼 스트라이크를 제대로 반환하는지 확인하는 테스트 코드")
    void compareBallOneByOne(Baseball baseball, Baseball anoterBaseball, BallStatus expect) {
        assertThat(baseball.checkBaseball(anoterBaseball)).isEqualTo(expect);
    }

    static Stream<Arguments> baseballParameterProvider() {
        return Stream.of(arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 1), BallStatus.STRIKE_STATUS),
                arguments(new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("2"), 1), BallStatus.STRIKE_STATUS),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("1"), 2), BallStatus.STRIKE_STATUS),
                arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 2), BallStatus.BALL_STATUS),
                arguments(new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("2"), 3), BallStatus.BALL_STATUS),
                arguments(new Baseball(new BaseballNumber("6"), 1), new Baseball(new BaseballNumber("6"), 2), BallStatus.BALL_STATUS),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("3"), 1), BallStatus.NOTHING_STATUS),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("3"), 2), BallStatus.NOTHING_STATUS));
    }
}