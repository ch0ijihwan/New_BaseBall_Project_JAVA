package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private Game game;
    private Baseballs baseballs;
    private Baseballs otherBaseballs;
    private Baseball firstBall;
    private Baseball secondBall;
    private Baseball thirdBall;

    @BeforeEach
    void setUp() {
        firstBall = new Baseball(1, 0);
        secondBall = new Baseball(2, 1);
        thirdBall = new Baseball(3, 2);
        baseballs = new Baseballs(Arrays.asList(firstBall, secondBall, thirdBall));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,0", "3,1,2,3", "3,2,1,2", "4,5,6,0"})
    @DisplayName("countBall 실행시 볼 개수를 받아 반환하는지 확인")
    void countBall(int firstNumber, int secondNumber, int thirdNumber, int expect) {
        //given
        Baseball otherFirstBall = new Baseball(firstNumber, 0);
        Baseball otherSecondBall = new Baseball(secondNumber, 1);
        Baseball otherThirdBall = new Baseball(thirdNumber, 2);
        otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        game = new Game(baseballs, otherBaseballs);

        //when
        int actual = game.countBallStatus();

        //Then
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,3", "3,1,2,0", "3,2,1,1", "4,5,6,0"})
    @DisplayName("countStrike 실행시 스트라이크 개수를 받아 반환하는지 확인")
    void countStrike(int firstNumber, int secondNumber, int thirdNumber, int expect) {
        //given
        Baseball otherFirstBall = new Baseball(firstNumber, 0);
        Baseball otherSecondBall = new Baseball(secondNumber, 1);
        Baseball otherThirdBall = new Baseball(thirdNumber, 2);
        otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        game = new Game(baseballs, otherBaseballs);

        //when
        int actual = game.contStrikeStatus();

        //Then
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,true", "3,2,1,false"})
    @DisplayName("threeStrike 인 경우 true 반환을 확인.")
    void isOver(int firstNumber, int secondNumber, int thirdNumber, boolean expect) {
        //given
        Baseball otherFirstBall = new Baseball(firstNumber, 0);
        Baseball otherSecondBall = new Baseball(secondNumber, 1);
        Baseball otherThirdBall = new Baseball(thirdNumber, 2);
        otherBaseballs = new Baseballs(Arrays.asList(otherFirstBall, otherSecondBall, otherThirdBall));
        Game game = new Game(baseballs, otherBaseballs);

        //when
        Boolean actual = game.isThreeStrike();

        //Then
        assertThat(actual).isEqualTo(expect);
    }
}