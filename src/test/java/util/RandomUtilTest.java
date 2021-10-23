package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.RandomUtil.generateRandomNumber;

class RandomUtilTest {
    @Test
    @DisplayName("generateRandomNumber() 호출 시 0보다 크고 10보다 작은 한자리수 반환하는 확인하는 테스트 코드")
    void greaterThanZeroAndLessThanTen() {
        assertThat(generateRandomNumber()).isPositive().isLessThan(10);
    }
}