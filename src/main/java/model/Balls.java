package model;

import model.ball.Ball;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    private static final int NUMBER_OF_BASEBALL_GAME_INPUT = 3;
    private static final int START = 0;
    private final List<Ball> threeBalls;

    public Balls(String[] inputtedBallNumbers) {
        validateBallsSize(inputtedBallNumbers);

        threeBalls = IntStream.range(START, inputtedBallNumbers.length)
                .mapToObj(index -> new Ball(Integer.parseInt(inputtedBallNumbers[index]), index))
                .collect(Collectors.toUnmodifiableList());
    }

    public Balls(List<Integer> inputtedBallNumbers) {
        validateBallsSize(inputtedBallNumbers);
        threeBalls = IntStream.range(START, inputtedBallNumbers.size())
                .mapToObj(index -> new Ball(inputtedBallNumbers.get(index), index))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateBallsSize(List<Integer> inputtedBallNumbers) {
        if (inputtedBallNumbers.stream().distinct().count() != NUMBER_OF_BASEBALL_GAME_INPUT) {
            throw new IllegalArgumentException("숫자 야구 게임의 숫자 입력 길이는 3자리 입니다.");
        }
    }

    private void validateBallsSize(String[] inputtedBallNumbers) {
        if (Arrays.stream(inputtedBallNumbers).distinct().count() != NUMBER_OF_BASEBALL_GAME_INPUT) {
            throw new IllegalArgumentException("숫자 야구 게임의 숫자 입력 길이는 3자리 입니다.");
        }
    }

    public List<BallStatus> compareThreeBall(Balls anotherBalls) {
        return threeBalls.stream()
                .map(anotherBalls::compareBall)
                .collect(Collectors.toList());
    }

    private BallStatus compareBall(Ball anotherBall) {
        return threeBalls.stream()
                .map(anotherBall::compareBallStatus)
                .filter(ballStatus -> ballStatus == BallStatus.BALL || ballStatus == BallStatus.STRIKE)
                .findAny()
                .orElse(BallStatus.NOTHING);
    }

    public int getBallPosition(int index) {
        return threeBalls.get(index)
                .getBallPositionValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(threeBalls, balls1.threeBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threeBalls);
    }

    @Override
    public String toString() {
        return "Balls{" +
                "balls=" + threeBalls +
                '}';
    }
}
