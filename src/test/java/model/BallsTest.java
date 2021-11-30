package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {
    @Test
    @DisplayName("객체 생성 시, 숫자 리스트를 입력 받고 이를 Ball 객체로 만들어 리스트로 저장한다.")
    void createBalls() {
        //given
        List<Integer> inputtedBallsNumbers = Arrays.asList(1, 2, 3);
        List<Integer> expectedBallsNumbers = Arrays.asList(1, 2, 3);

        //when
        Balls actualBalls = new Balls(inputtedBallsNumbers);

        //then
        assertThat(actualBalls).isEqualTo(new Balls(expectedBallsNumbers));
    }

    @ParameterizedTest
    @DisplayName("객체 생성 시, 생성자의 파리미터로 입력 된, 야구 숫자의 갯수가 3개가 아니면 예외처리를 반환한다.")
    @CsvSource(value = {"1 2", "1 2 3 4"})
    void validateBallsSize(String values) {
        int[] input = Arrays.stream(values.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> inputtedNumbers = Arrays.stream(input).boxed().collect(Collectors.toUnmodifiableList());

        assertThatThrownBy(() -> new Balls(inputtedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 야구 게임의 숫자 입력 길이는 3자리 입니다.");
    }
}