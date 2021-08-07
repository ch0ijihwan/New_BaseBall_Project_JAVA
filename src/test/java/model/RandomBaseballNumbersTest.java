package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBaseballNumbersTest {
    RandomBaseballNumbers randomBaseballNumbers = new RandomBaseballNumbers();

    @Test
    @DisplayName("램던 베이스볼의 갯수가 3개인지 확인")
    void randomBaseball() {
        assertThat(randomBaseballNumbers.getRandomBaseballNumbers().size()).isEqualTo(3);
    }
}