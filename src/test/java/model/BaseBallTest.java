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

    @ParameterizedTest
    @MethodSource("checkBallParameterProvider")
    @DisplayName("공 두개를 비교하여, Strike인 경우 1,Ball 인경우 2, Nothing인 경우 0을 반환함을 확인.")
    void checkBall(BaseBall baseBall, BaseBall anotherBall, int expect) {
        Assertions.assertThat(baseBall.checkBall(anotherBall)).isEqualTo(expect);
    }

    static Stream<Arguments> checkBallParameterProvider() {
        return Stream.of(arguments(new BaseBall(new BaseballNumber("1"), 1), new BaseBall(new BaseballNumber("1"), 1), 1),
                arguments(new BaseBall(new BaseballNumber("1"), 1), new BaseBall(new BaseballNumber("1"), 2), 2),
                arguments(new BaseBall(new BaseballNumber("1"), 1), new BaseBall(new BaseballNumber("2"), 1), 0),
                arguments(new BaseBall(new BaseballNumber("1"), 2), new BaseBall(new BaseballNumber("2"), 2), 0),
                arguments(new BaseBall(new BaseballNumber("3"), 1), new BaseBall(new BaseballNumber("3"), 2), 2),
                arguments(new BaseBall(new BaseballNumber("3"), 1), new BaseBall(new BaseballNumber("3"), 1), 1)
        );
    }
}