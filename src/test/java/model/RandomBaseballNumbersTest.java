package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RandomBaseballNumbersTest {

    private static RandomBaseballNumbers randomBaseballNumbers = new RandomBaseballNumbers();

    @Test
    @DisplayName("램던 베이스볼의 갯수가 3개인지 확인")
    void randomBaseball() {
        assertThat(randomBaseballNumbers.getRandomBaseballNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("randomBaseballParameterProvider")
    @DisplayName("생성된 랜덤 베이스볼에 각각 0보다 크고 10 보다 작은 값이 있는지 확인")
    void allNumberIsGreaterThanZeroAndLessThanTen(List<Number> numbers) {
        assertAll(
                () -> assertThat(numbers.get(0).value()).isGreaterThan(0).isLessThan(10),
                () -> assertThat(numbers.get(1).value()).isGreaterThan(0).isLessThan(10),
                () -> assertThat(numbers.get(2).value()).isGreaterThan(0).isLessThan(10)
        );
    }

    static Stream<Arguments> randomBaseballParameterProvider() {
        return Stream.of(arguments(new ArrayList<>( new RandomBaseballNumbers().getRandomBaseballNumbers())),
                arguments(new ArrayList<>(new RandomBaseballNumbers().getRandomBaseballNumbers())),
                arguments(new ArrayList<>(new RandomBaseballNumbers().getRandomBaseballNumbers())),
                arguments(new ArrayList<>(new RandomBaseballNumbers().getRandomBaseballNumbers())),
                arguments(new ArrayList<>(new RandomBaseballNumbers().getRandomBaseballNumbers())));
    }
}