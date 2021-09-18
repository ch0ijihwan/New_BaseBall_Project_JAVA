package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RandomBaseballNumbersGeneratorTest {
    private static final int MAX_NUMBER = 10;
    private static RandomBaseballNumbersGenerator randomBaseballNumbers = new RandomBaseballNumbersGenerator();

    @Test
    @DisplayName("램던 베이스볼의 갯수가 3개인지 확인")
    void randomBaseball() {
        assertThat(randomBaseballNumbers.getRandomBaseballNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("randomBaseballParameterProvider")
    @DisplayName("생성된 랜덤 베이스볼에 각각 0보다 크고 10 보다 작은 값이 있는지 확인")
    void allNumberIsGreaterThanZeroAndLessThanTen(List<BaseballNumber> numbers) {
        assertAll(
                () -> assertThat(numbers.get(0).value()).isPositive().isLessThan(MAX_NUMBER),
                () -> assertThat(numbers.get(1).value()).isPositive().isLessThan(MAX_NUMBER),
                () -> assertThat(numbers.get(2).value()).isPositive().isLessThan(MAX_NUMBER)
        );
    }

    static Stream<Arguments> randomBaseballParameterProvider() {
        return Stream.of(arguments(new RandomBaseballNumbersGenerator().getRandomBaseballNumbers()),
                arguments(new RandomBaseballNumbersGenerator().getRandomBaseballNumbers()),
                arguments(new RandomBaseballNumbersGenerator().getRandomBaseballNumbers()),
                arguments(new RandomBaseballNumbersGenerator().getRandomBaseballNumbers()),
                arguments(new RandomBaseballNumbersGenerator().getRandomBaseballNumbers()));
    }
}