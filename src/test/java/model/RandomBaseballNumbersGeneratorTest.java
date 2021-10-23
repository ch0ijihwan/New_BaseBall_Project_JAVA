package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBaseballNumbersGeneratorTest {
    private static final RandomBaseballsGenerator randomBaseballNumbers = new RandomBaseballsGenerator();

    @Test
    @DisplayName("getRandomNumbers 호출시 3자릿수를 가지고 있는 int형 값이 반환되는지 확인")
    void randomBaseball() {
        //given
        RandomNumberGenerator randomBaseballGenerator = new RandomNumberGenerator();
        int expected = 3;

        //when
        int actual = randomBaseballGenerator.getRandomNumbers().length;

        //then
        assertThat(actual).isEqualTo(expected);
    }
}