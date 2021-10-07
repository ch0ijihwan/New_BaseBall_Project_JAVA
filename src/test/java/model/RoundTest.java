package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RoundTest {
    private static final int BALL_COUNT_INDEX = 0;
    public static final int STRIKE_COUNT_INDEX = 1;
    private Round round;

    @ParameterizedTest
    @MethodSource("judgeResultParameterProvider")
    @DisplayName(" TotalResult를 통해 스트라이크 개수와 볼 개수를 받아 반환하는지 확인")
    void judgeResult(Baseballs inputNumbers, Baseballs randomNumbers, int ballCount, int strikeCount) {
        round = new Round(inputNumbers, randomNumbers);

        assertAll(
                () -> assertThat(round.judgeResult().get(BALL_COUNT_INDEX)).isEqualTo(ballCount),
                () -> assertThat(round.judgeResult().get(STRIKE_COUNT_INDEX)).isEqualTo(strikeCount)
        );
    }

    @ParameterizedTest
    @MethodSource("threeStrikeCountParameterProvider")
    @DisplayName("threeStrike 인 경우 true 반환을 확인.")
    void isOver(Baseballs inputNumbers, Baseballs randomNumbers, boolean expect) {
        Round round = new Round(inputNumbers, randomNumbers);
        boolean resultStrikeCount = round.isThreeStrike();
        assertThat(resultStrikeCount).isEqualTo(expect);
    }

    static Stream<Arguments> judgeResultParameterProvider() {
        return Stream.of(arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2))),
                        (new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2)))), 0, 3),

                arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2))),
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("3"), 0), new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("2"), 2))), 3, 0),

                arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2))),
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("9"), 1), new Baseball(new BaseballNumber("8"), 2))), 0, 1),

                arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2))),
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("2"), 0), new Baseball(new BaseballNumber("1"), 1), new Baseball(new BaseballNumber("8"), 2))), 2, 0),

                arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("5"), 2))),
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("4"), 2))), 0, 2));
    }

    static Stream<Arguments> threeStrikeCountParameterProvider() {
        return Stream.of(arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2))),
                        (new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2)))), true),

                arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2))),
                        (new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 0)))), false),

                arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2))),
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("4"), 0), new Baseball(new BaseballNumber("5"), 1), new Baseball(new BaseballNumber("6"), 2))), false),

                arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 0))),
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 0))), true),

                arguments(new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("4"), 0), new Baseball(new BaseballNumber("5"), 1), new Baseball(new BaseballNumber("6"), 2))),
                        new Baseballs(Arrays.asList(new Baseball(new BaseballNumber("4"), 0), new Baseball(new BaseballNumber("5"), 1), new Baseball(new BaseballNumber("6"), 2))), true));
    }
}