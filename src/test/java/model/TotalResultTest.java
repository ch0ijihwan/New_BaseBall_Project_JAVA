package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TotalResultTest {
    private TotalResult totalResult;

    @ParameterizedTest
    @MethodSource("BaseballStatusResultForCheckBallParameterProvider")
    @DisplayName("Ballstatus 리스트를 받아 그중 볼의 갯수를 파악하여 반환하는지 확인")
    void countBall(List<BallStatus> ballStatusesResult, int expect){
        totalResult = new TotalResult(ballStatusesResult);
        assertThat(totalResult.countBallScore()).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("BaseballStatusResultForCheckStrikeParameterProvider")
    @DisplayName("Ballstatus 리스트를 받아 그중 스트라이크의 갯수를 파악하여 반환하는지 확인")
    void countStrike(List<BallStatus> ballStatusesResult, int expect){
        totalResult = new TotalResult(ballStatusesResult);
        assertThat(totalResult.countStrikeScore()).isEqualTo(expect);

    }
    static Stream<Arguments> BaseballStatusResultForCheckBallParameterProvider() {
        return Stream.of(arguments(Arrays.asList(BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS),0),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS),1),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.STRIKE_STATUS, BallStatus.NOTHING_STATUS),1),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.BALL_STATUS, BallStatus.STRIKE_STATUS),2),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.BALL_STATUS, BallStatus.NOTHING_STATUS),2),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.BALL_STATUS, BallStatus.BALL_STATUS),3),
                arguments(Arrays.asList(BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS),0));
    }

    static Stream<Arguments> BaseballStatusResultForCheckStrikeParameterProvider() {
        return Stream.of(arguments(Arrays.asList(BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS),3),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS),2),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.STRIKE_STATUS, BallStatus.NOTHING_STATUS),1),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.BALL_STATUS, BallStatus.STRIKE_STATUS),1),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.BALL_STATUS, BallStatus.NOTHING_STATUS),0),
                arguments(Arrays.asList(BallStatus.BALL_STATUS, BallStatus.BALL_STATUS, BallStatus.BALL_STATUS),0),
                arguments(Arrays.asList(BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS, BallStatus.STRIKE_STATUS),3));
    }
}