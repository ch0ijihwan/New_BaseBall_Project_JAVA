package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.util.randomUtil.generateRandomNumber;
import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {
    @Test
    @DisplayName("generateRandomNumber() 호출 시, 0보다 크고 10보다 작은 한 자리 숫자를 반환한다.")
    void greaterThanZeroAndLessThanTen() {
        assertThat(generateRandomNumber()).isPositive().isLessThan(10);
    }
}
