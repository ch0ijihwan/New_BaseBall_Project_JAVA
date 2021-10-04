package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static util.RandomUtil.generateRandomNumber;

class RandomUtilTest {
    @ParameterizedTest
    @MethodSource("randomUtilParameterProvider")
    @DisplayName("0보다크고 10보다 작은 한자리수 반환")
    void greaterThanZeroAndLessThanTen(int number) {
        assertThat(number).isPositive().isLessThan(10);
    }

    static Stream<Arguments> randomUtilParameterProvider() {
        return Stream.of(arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()),
                arguments(generateRandomNumber()));
    }
}