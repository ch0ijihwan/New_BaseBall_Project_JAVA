package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballTest {
    @ParameterizedTest
    @MethodSource("checkBallParameterProvider")
    @DisplayName("공 두개를 비교하여, Strike인 경우 1,Ball 인경우 2, Nothing인 경우 0을 반환함을 확인.")
    void checkBall(Baseball baseBall, Baseball anotherBall, BallStatus expect) {
        assertThat(baseBall.checkBaseball(anotherBall)).isEqualTo(expect);
    }

    static Stream<Arguments> checkBallParameterProvider() {
        return Stream.of(arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 1), BallStatus.STRIKE_STATUS),
                arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("1"), 2), BallStatus.BALL_STATUS),
                arguments(new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("2"), 1), BallStatus.NOTHING_STATUS),
                arguments(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("2"), 2), BallStatus.NOTHING_STATUS),
                arguments(new Baseball(new BaseballNumber("3"), 1), new Baseball(new BaseballNumber("3"), 2), BallStatus.BALL_STATUS),
                arguments(new Baseball(new BaseballNumber("3"), 1), new Baseball(new BaseballNumber("3"), 1), BallStatus.STRIKE_STATUS)
        );
    }
}