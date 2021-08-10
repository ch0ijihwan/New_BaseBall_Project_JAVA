package model.score;

import model.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BallTest {
    @ParameterizedTest
    @MethodSource("ballCountParameterProvider")
    @DisplayName("4가지 두 List을 받아, 볼의 개수를 반환한다.")
    void getBallCount(List<Number> inputNumber, List<Number> randomNumber, int expect) {
        int count = Ball.countBall(inputNumber, randomNumber);
        assertThat(count).isEqualTo(expect);
    }

    static Stream<Arguments> ballCountParameterProvider() {
        return Stream.of(arguments((Arrays.asList(new Number("1"), new Number("2"), new Number("3"))),
                        (Arrays.asList(new Number("3"), new Number("1"), new Number("2"))), 3),
                arguments((Arrays.asList(new Number("1"), new Number("2"), new Number("3"))),
                        (Arrays.asList(new Number("2"), new Number("3"), new Number("4"))), 2),
                arguments((Arrays.asList(new Number("1"), new Number("2"), new Number("3"))),
                        (Arrays.asList(new Number("2"), new Number("5"), new Number("7"))), 1),
                arguments((Arrays.asList(new Number("1"), new Number("2"), new Number("3"))),
                        (Arrays.asList(new Number("4"), new Number("5"), new Number("6"))), 0)
        );
    }
}