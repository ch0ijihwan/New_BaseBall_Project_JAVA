package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballsTest {
    private Baseballs baseballs;

    @ParameterizedTest
    @MethodSource("createBaseballsParameterProvider")
    @DisplayName("새로운 숫자야구 넘버를 입력 받을 시 threeBalls 리스트를 생성하는지에 대한 테스트 코드")
    void makeBaseballs(int[] inputNumbers, Baseballs expect) {
        baseballs = new Baseballs(inputNumbers);

        assertAll(
                () -> assertThat(baseballs.compareThreeBall(expect).get(0)).isEqualTo(BallStatus.STRIKE),
                () -> assertThat(baseballs.compareThreeBall(expect).get(1)).isEqualTo(BallStatus.STRIKE),
                () -> assertThat(baseballs.compareThreeBall(expect).get(2)).isEqualTo(BallStatus.STRIKE)
        );
    }

    static Stream<Arguments> createBaseballsParameterProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3},
                        new Baseballs(Arrays.asList(new Baseball(1, 0), new Baseball(2, 1), new Baseball(3, 2))),
                        arguments(new int[]{5, 4, 8},
                                new Baseballs(Arrays.asList(new Baseball(5, 0), new Baseball(4, 1), new Baseball(8, 2)))),
                        arguments(new int[]{9, 2, 5},
                                new Baseballs(Arrays.asList(new Baseball(9, 0), new Baseball(2, 1), new Baseball(5, 2))))
                )
        );
    }

    @Test
    @DisplayName("공을 세개씩 가진 두 야구공리스트을 비교하여, 그 비교값(볼, 스트라이크, 낫씽)을 리스트화 하여 반환하는지 확인")
    void compareThreeBall() {
        //given
        Baseball firstBall = new Baseball(1, 0);
        Baseball secondBall = new Baseball(2, 1);
        Baseball thirdBall = new Baseball(3, 2);
        Baseball otherFirstBall = new Baseball(1, 0);
        Baseball otherSecondBall = new Baseball(3, 1);
        Baseball otherThirdBall = new Baseball(8, 2);

        baseballs = new Baseballs(Arrays.asList(firstBall, secondBall, thirdBall));
        Baseballs otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        List<BallStatus> expect = Arrays.asList(BallStatus.STRIKE, BallStatus.NOTHING, BallStatus.BALL);

        //when
        List<BallStatus> actual = baseballs.compareThreeBall(otherBaseballs);

        //Then
        assertThat(actual).isEqualTo(expect);
    }
}