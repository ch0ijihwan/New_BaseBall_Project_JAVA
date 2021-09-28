package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @BeforeEach
    void setUp() {
        List<Baseball> threeBalls = new ArrayList<>();

        Baseball firstBall = new Baseball(new BaseballNumber("1"), 1);
        Baseball secondBall = new Baseball(new BaseballNumber("2"), 2);
        Baseball thirdBall = new Baseball(new BaseballNumber("3"), 3);

        threeBalls.add(firstBall);
        threeBalls.add(secondBall);
        threeBalls.add(thirdBall);

        Baseballs baseballs = new Baseballs(threeBalls);
    }

    @ParameterizedTest
    @MethodSource("baseballParameterProvider")
    @DisplayName("서로 다른 공 두개를 서로 비교하여 볼 스트라이크를 제대로 반환하는지 확인하는 테스트 코드")
    void compareBallOneByOne(Baseball baseball, Baseball anoterBaseball, int expect) {
        assertThat(baseball.checkBaseball(anoterBaseball)).isEqualTo(expect);
    }

    static Stream<Arguments> baseballParameterProvider() {
        return Stream.of(arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 1), STRIKE),
                arguments(new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("2"), 1),STRIKE),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("1"), 2),STRIKE));
    }


}