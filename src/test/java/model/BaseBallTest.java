package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseBallTest {
    private BaseBall baseBall;
    private BaseBall anotherBall;

    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;

    @ParameterizedTest
    @MethodSource("checkBallParameterProvider")
    @DisplayName("공 두개를 비교하여, Strike인 경우 1,Ball 인경우 2, Nothing인 경우 0을 반환함을 확인.")
    void checkBall(BaseBall baseBall, BaseBall anotherBall, int expect) {
        Assertions.assertThat(baseBall.checkBall(anotherBall)).isEqualTo(expect);
    }

    static Stream<Arguments> checkBallParameterProvider() {
        return Stream.of(arguments(new BaseBall(new BaseballNumber("1"), 1), new BaseBall(new BaseballNumber("1"), 1), STRIKE),
                arguments(new BaseBall(new BaseballNumber("1"), 1), new BaseBall(new BaseballNumber("1"), 2), BALL),
                arguments(new BaseBall(new BaseballNumber("1"), 1), new BaseBall(new BaseballNumber("2"), 1), NOTHING),
                arguments(new BaseBall(new BaseballNumber("1"), 2), new BaseBall(new BaseballNumber("2"), 2), NOTHING),
                arguments(new BaseBall(new BaseballNumber("3"), 1), new BaseBall(new BaseballNumber("3"), 2), BALL),
                arguments(new BaseBall(new BaseballNumber("3"), 1), new BaseBall(new BaseballNumber("3"), 1), STRIKE)

        );
    }
}