package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BallsTest {
    @Test
    @DisplayName("객체 생성 시, 숫자 리스트를 입력 받고 이를 Ball 객체로 만들어 리스트로 저장한다.")
    void createBalls() {
        //given
        List<Integer> inputtedBallsNumbers = Arrays.asList(1, 2, 3);
        List<Integer> expectedBallsNumbers = Arrays.asList(1, 2, 3);

        //when
        Balls actualBalls = new Balls(inputtedBallsNumbers);

        //then
        assertThat(actualBalls).isEqualTo(new Balls(expectedBallsNumbers));
    }

    @Test
    @DisplayName("객체 생성 시, 숫자 리스트를 입력 받는다. 이떄 입력 받은 순서인 (0 ,1,2)를 가진 포지션 객체를" +
            " 가지는 Ball 객체를 만들어 리스트로 저장한다.")
    void createPosition() {
        //given
        List<Integer> inputtedBallsNumbers = Arrays.asList(1, 2, 3);

        //when
        Balls actualBalls = new Balls(inputtedBallsNumbers);

        //then
        assertAll(
                () -> assertThat(actualBalls.getBallPosition(0)).isEqualTo(0),
                () -> assertThat(actualBalls.getBallPosition(1)).isEqualTo(1),
                () -> assertThat(actualBalls.getBallPosition(2)).isEqualTo(2)
        );
    }

    @ParameterizedTest
    @DisplayName("객체 생성 시, 생성자의 파리미터로 입력 된, 야구 숫자의 갯수가 3개가 아니면 예외처리를 반환한다.")
    @CsvSource(value = {"1 2", "1 2 3 4"})
    void validateBallsSize(String values) {
        int[] input = Arrays.stream(values.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> inputtedNumbers = Arrays.stream(input).boxed().collect(Collectors.toUnmodifiableList());

        assertThatThrownBy(() -> new Balls(inputtedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 야구 게임의 숫자 입력 길이는 3자리 입니다.");
    }

    @ParameterizedTest
    @DisplayName("compareBalls() 실행 시, 파리미터로 부터 입력된 balls 객체와 비교하여, 숫자 야구 게임의 결과를 반환한다.")
    @MethodSource("anotherBallsParameterProvider")
    void compareBalls(Balls anotherBalls, List<BallStatus> expectedBallStatus) {
        //given
        Balls balls = new Balls(List.of(1, 2, 3));

        //when
        List<BallStatus> actualBallStatus = balls.compareThreeBall(anotherBalls);

        //then
        assertThat(actualBallStatus).isEqualTo(expectedBallStatus);
    }

    static Stream<Arguments> anotherBallsParameterProvider() {
        return Stream.of(
                arguments(new Balls(List.of(1, 2, 3)), List.of(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.STRIKE)),
                arguments(new Balls(List.of(3, 1, 2)), List.of(BallStatus.BALL, BallStatus.BALL, BallStatus.BALL)),
                arguments(new Balls(List.of(4, 5, 6)), List.of(BallStatus.NOTHING, BallStatus.NOTHING, BallStatus.NOTHING)),
                arguments(new Balls(List.of(1, 3, 6)), List.of(BallStatus.STRIKE, BallStatus.NOTHING, BallStatus.BALL))
        );
    }
}