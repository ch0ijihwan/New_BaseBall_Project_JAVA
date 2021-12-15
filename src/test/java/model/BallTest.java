package model;

import model.ball.Ball;
import model.ball.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BallTest {
    private Ball ball;

    @Test
    @DisplayName("객체 생성 시, 파라미터로 부터 입력 받은 값을 각각 BaseballNumber 와 Position 으로 저장한다.")
    void createBall() {
        //given
        int inputtedBaseballNumber = 1;
        int inputtedPosition = 2;
        int expectedBaseballNumber = 1;
        int expectedPosition = 2;

        //when
        ball = new Ball(inputtedBaseballNumber, inputtedPosition);

        //then
        assertThat(ball).isEqualTo(new Ball(expectedBaseballNumber, expectedPosition));
    }

    @ParameterizedTest
    @DisplayName("compareBallStatus() 호출 시, 파라미터로 부터 입력 받은 Ball 객체와 비교하여, BallStatus 를 반환한다.")
    @MethodSource("anotherBallParameterProvider")
    void compareBallStatus(Ball anotherBall, BallStatus expectedStatus) {
        //given
        int inputtedBaseballNumber = 1;
        int inputtedPosition = 1;
        ball = new Ball(inputtedBaseballNumber, inputtedPosition);

        //when
        BallStatus actualBallStatus = ball.compareBallStatus(anotherBall);

        //then
        assertThat(actualBallStatus).isEqualTo(expectedStatus);
    }

    static Stream<Arguments> anotherBallParameterProvider() {
        return Stream.of(
                arguments(new Ball(1, 1), BallStatus.STRIKE),
                arguments(new Ball(1, 2), BallStatus.BALL),
                arguments(new Ball(2, 2), BallStatus.NOTHING)
        );
    }
}
