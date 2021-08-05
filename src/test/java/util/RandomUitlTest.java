package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.RandomUitl.generateRandomNumber;

class RandomUitlTest {
    @Test
    @DisplayName("0보다크고 10보다 작은 한자리수 반환")
    void greaterThanZeroAndLessThanTen() {
        int randomNumber = generateRandomNumber();

        assertThat(randomNumber).isGreaterThan(0).isLessThan(10);
    }
}