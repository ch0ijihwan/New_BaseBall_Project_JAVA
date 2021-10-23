package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {
    @ParameterizedTest
    @MethodSource("checkBallParameterProvider")
    @DisplayName("공 두개를 비교하여, Strike인 경우 1,Ball 인경우 2, Nothing인 경우 0을 반환함을 확인.")
    void checkBall(Baseball baseBall, Baseball anotherBall, BallStatus expect) {
        assertThat(baseBall.checkBaseball(anotherBall)).isEqualTo(expect);
    }
}