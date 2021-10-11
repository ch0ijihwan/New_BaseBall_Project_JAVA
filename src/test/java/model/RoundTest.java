package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundTest {
    private Round round;
    private Baseballs baseballs;
    private Baseballs otherBaseballs;

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,0,3", "3,1,2,3,0", "3,2,1,2,1", "4,5,6,0,0"})

    @DisplayName("  스트라이크 개수와 볼 개수를 받아 반환하는지 확인")
    void judgeResult(String firstNumber, String secondNumber, String thirdNumber, int ballExpet, int strikeExpet) {
        Baseball firstBall = new Baseball(new BaseballNumber("1"), 0);
        Baseball secondBall = new Baseball(new BaseballNumber("2"), 1);
        Baseball thirdBall = new Baseball(new BaseballNumber("3"), 2);
        Baseball otherFirstBall = new Baseball(new BaseballNumber(firstNumber), 0);
        Baseball otherSecondBall = new Baseball(new BaseballNumber(secondNumber), 1);
        Baseball otherThirdBall = new Baseball(new BaseballNumber(thirdNumber), 2);

        baseballs = new Baseballs(Arrays.asList(firstBall, secondBall, thirdBall));
        otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        round = new Round(baseballs, otherBaseballs);
        assertAll(
                () -> assertThat(round.getBallCount()).isEqualTo(ballExpet),
                () -> assertThat(round.getStrikeCount()).isEqualTo(strikeExpet)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,true", "3,2,1,false"})
    @DisplayName("threeStrike 인 경우 true 반환을 확인.")
    void isOver(String firstNumber, String secondNumber, String thirdNumber, boolean expect) {
        Baseball firstBall = new Baseball(new BaseballNumber("1"), 0);
        Baseball secondBall = new Baseball(new BaseballNumber("2"), 1);
        Baseball thirdBall = new Baseball(new BaseballNumber("3"), 2);
        Baseball otherFirstBall = new Baseball(new BaseballNumber(firstNumber), 0);
        Baseball otherSecondBall = new Baseball(new BaseballNumber(secondNumber), 1);
        Baseball otherThirdBall = new Baseball(new BaseballNumber(thirdNumber), 2);

        baseballs = new Baseballs(Arrays.asList(firstBall, secondBall, thirdBall));
        otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        Round round = new Round(baseballs, otherBaseballs);
       
        assertThat(round.isThreeStrike()).isEqualTo(expect);
    }
}