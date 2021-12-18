package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {
    private Balls balls;
    private Balls anotherBalls;

    @BeforeEach
    void setUp() {
        List<Integer> ballsNumber = List.of(1, 2, 3);
        List<Integer> anotherBallsNumbers = List.of(1, 3, 4);

        balls = new Balls(ballsNumber);
        anotherBalls = new Balls(anotherBallsNumbers);
    }

    @Test
    @DisplayName("countStrike() 실행 시, 스트라이크의 갯수를 반환한다.")
    void countStrike() {
        //given
        Round round = new Round(balls, anotherBalls);
        int expected = 1;

        //when
        int actual = round.countStrike();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("countBall() 실행 시, 볼의 갯수를 반환한다.")
    void countBall() {
        //given
        Round round = new Round(balls, anotherBalls);
        int expected = 1;

        //when
        int actual = round.countBall();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("isThreeStrike() 호출 시, 스트라이크의 갯수가 3개인 경우 true 를 반환한다.")
    void isThreeStrike() {
        //given
        anotherBalls = new Balls(List.of(1, 2, 3));
        Round round = new Round(balls, anotherBalls);

        //when
        boolean actual = round.isThreeStrike();

        //then
        assertThat(actual).isTrue();
    }
}
