package model.score;

import model.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StrikeTest {

    @ParameterizedTest
    @MethodSource("strikeCountParameterProvider")
    @DisplayName("4가지 두 Set을 받아 스트라이크의 개수를 반환한다.")
    void getStrikeCount(List<BaseballNumber> inputNumbers, List<BaseballNumber> randomNumbers, int expect) {
        int count = Strike.countStrike(inputNumbers, randomNumbers);
        assertThat(count).isEqualTo(expect);
    }

    static Stream<Arguments> strikeCountParameterProvider() {
        return Stream.of(arguments(Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")),
                        Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")), 3),
                arguments(Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")),
                        Arrays.asList(new BaseballNumber("6"), new BaseballNumber("2"), new BaseballNumber("3")), 2),
                arguments(Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")),
                        Arrays.asList(new BaseballNumber("7"), new BaseballNumber("6"), new BaseballNumber("3")), 1),
                arguments(Arrays.asList(new BaseballNumber("1"), new BaseballNumber("2"), new BaseballNumber("3")),
                        Arrays.asList(new BaseballNumber("4"), new BaseballNumber("5"), new BaseballNumber("6")), 0)
        );
    }
}