package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBallNumbersGeneratorTest {
    @Test
    @DisplayName("getRandomBallNumbers() 호출 시, 중복이 없는 랜덤 숫자 3개를 리스트 형태로 반환한다.")
    void crateRandomNumbers() {
        //given
        RandomBallNumbersGenerator randomBallNumbersGenerator = new RandomBallNumbersGenerator();
        int expectedSize = 3;

        //when
        int actualSize = randomBallNumbersGenerator.getRandomBallNumber().size();

        //then
        assertThat(actualSize).isEqualTo(expectedSize);
    }
}
