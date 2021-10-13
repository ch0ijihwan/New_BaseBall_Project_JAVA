package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameTest {
    private Game game;
    private Baseballs baseballs;
    private Baseballs otherBaseballs;
    private Baseball firstBall;
    private Baseball secondBall;
    private Baseball thirdBall;

    @BeforeEach
    void setUp() {
        firstBall = new Baseball(new BaseballNumber(1), 0);
        secondBall = new Baseball(new BaseballNumber(2), 1);
        thirdBall = new Baseball(new BaseballNumber(3), 2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,0,3", "3,1,2,3,0", "3,2,1,2,1", "4,5,6,0,0"})
    @DisplayName("  스트라이크 개수와 볼 개수를 받아 반환하는지 확인")
    void judgeResult(int firstNumber, int secondNumber, int thirdNumber, int ballExpet, int strikeExpet) {
        Baseball otherFirstBall = new Baseball(new BaseballNumber(firstNumber), 0);
        Baseball otherSecondBall = new Baseball(new BaseballNumber(secondNumber), 1);
        Baseball otherThirdBall = new Baseball(new BaseballNumber(thirdNumber), 2);

        baseballs = new Baseballs(Arrays.asList(firstBall, secondBall, thirdBall));
        otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        game = new Game(baseballs, otherBaseballs);
        assertAll(
                () -> assertThat(game.countBallStatus()).isEqualTo(ballExpet),
                () -> assertThat(game.contStrikeStatus()).isEqualTo(strikeExpet)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,true", "3,2,1,false"})
    @DisplayName("threeStrike 인 경우 true 반환을 확인.")
    void isOver(int firstNumber, int secondNumber, int thirdNumber, boolean expect) {
        Baseball otherFirstBall = new Baseball(new BaseballNumber(firstNumber), 0);
        Baseball otherSecondBall = new Baseball(new BaseballNumber(secondNumber), 1);
        Baseball otherThirdBall = new Baseball(new BaseballNumber(thirdNumber), 2);

        baseballs = new Baseballs(Arrays.asList(firstBall, secondBall, thirdBall));
        otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        Game game = new Game(baseballs, otherBaseballs);

        assertThat(game.isThreeStrike()).isEqualTo(expect);
    }
}