package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBaseballNumbersGeneratorTest {
    private static final RandomBaseballsGenerator randomBaseballNumbers = new RandomBaseballsGenerator();

    @Test
    @DisplayName("램던 베이스볼의 갯수가 3개인지 확인")
    void randomBaseball() {
        assertThat(randomBaseballNumbers.getRandomBaseballs().size()).isEqualTo(3);
    }
}