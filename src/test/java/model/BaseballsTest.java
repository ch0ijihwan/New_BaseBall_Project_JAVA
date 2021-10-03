package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballsTest {
    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;

    private Baseballs baseballs;
    private Baseballs otherBaseballs;
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

    @Test
    @DisplayName("공을 세개씩 가진 두 야구공을 비교하여, 그에대한 볼, 스트라이크, 낫씽을 리스트로 반환하는지 확인")
    void compareThreeBall() {
        baseballs = new Baseballs(threeBalls);
        otherBaseballs = new Baseballs(otherThreeBalls);
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(0);
        expect.add(2);

        assertThat(baseballs.compareThreeBall(otherBaseballs)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("baseballParameterProvider")
    @DisplayName("서로 다른 공 두개를 서로 비교하여 볼 스트라이크를 제대로 반환하는지 확인하는 테스트 코드")
    void compareBallOneByOne(Baseball baseball, Baseball anoterBaseball, int expect) {
        assertThat(baseball.checkBaseball(anoterBaseball)).isEqualTo(expect);
    }

    static Stream<Arguments> baseballParameterProvider() {
        return Stream.of(arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 1), STRIKE),
                arguments(new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("2"), 1), STRIKE),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("1"), 2), STRIKE),
                arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 2), BALL),
                arguments(new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("2"), 3), BALL),
                arguments(new Baseball(new BaseballNumber("6"), 1), new Baseball(new BaseballNumber("6"), 2), BALL),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("3"), 1), NOTHING),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("3"), 2), NOTHING));
    }
}