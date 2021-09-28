package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballTest {
    private Baseball baseBall;
    private Baseball anotherBall;

    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;

    @ParameterizedTest
    @MethodSource("constructBaseballParameterProvider")
    @DisplayName("생성된 baseball 객체에 야구 숫자와 공 위치가 제대로 입력됨을 확인하는 테스트 코드")
    void constructBaseball(Baseball baseball, int expectBallnumber, int expectPosition) {
        assertAll(
                () -> assertThat(baseball.value()).isEqualTo(expectBallnumber),
                () -> assertThat(baseball.getPosition()).isEqualTo(expectPosition)
        );
    }

    static Stream<Arguments> constructBaseballParameterProvider() {
        return Stream.of(arguments(new Baseball(new BaseballNumber("2"), 1), 2, 1),
                arguments(new Baseball(new BaseballNumber("1"), 1), 1, 1),
                arguments(new Baseball(new BaseballNumber("3"), 1), 3, 1));
    }

    @ParameterizedTest
    @MethodSource("checkBallParameterProvider")
    @DisplayName("공 두개를 비교하여, Strike인 경우 1,Ball 인경우 2, Nothing인 경우 0을 반환함을 확인.")
    void checkBall(Baseball baseBall, Baseball anotherBall, int expect) {
        assertThat(baseBall.checkBaseball(anotherBall)).isEqualTo(expect);
    }

    static Stream<Arguments> checkBallParameterProvider() {
        return Stream.of(arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 1), STRIKE),
                arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 2), BALL),
                arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("2"), 1), NOTHING),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("2"), 2), NOTHING),
                arguments(new Baseball(new BaseballNumber("3"), 1), new Baseball(new BaseballNumber("3"), 2), BALL),
                arguments(new Baseball(new BaseballNumber("3"), 1), new Baseball(new BaseballNumber("3"), 1), STRIKE)

        );
    }
}