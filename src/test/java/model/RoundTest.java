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

class RoundTest {
    @ParameterizedTest
    @MethodSource("threeStrikeCountParameterProvider")
    @DisplayName("threeStrike 인 경우 true 반환을 확인.")
    void isOver(List<BaseballNumber> inputNumbers, List<BaseballNumber> randomNumbers, boolean expect) {
        Round round = new Round(inputNumbers, randomNumbers);
        boolean resultStrikeCount = round.isOver();
        assertThat(resultStrikeCount).isEqualTo(expect);
    }

    static Stream<Arguments> threeStrikeCountParameterProvider() {
        return Stream.of(arguments(Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")),
                        Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")), false),
                arguments(Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")),
                        Arrays.asList(new BaseballNumber("6"), new BaseballNumber("2"), new BaseballNumber("3")), true),
                arguments(Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")),
                        Arrays.asList(new BaseballNumber("7"), new BaseballNumber("6"), new BaseballNumber("3")), true),
                arguments(Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")),
                        Arrays.asList(new BaseballNumber("4"), new BaseballNumber("5"), new BaseballNumber("6")), true)
        );
    }
}