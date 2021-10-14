package model;

import model.vo.Baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseballs {

    private static final int NUMBER_LENGTH = 3;

    private List<Baseball> threeBalls = new ArrayList<>();

    public Baseballs(List<Baseball> threeBalls) {
        this.threeBalls = threeBalls;
    }

    public Baseballs(int[] inputNumbers) {
        threeBalls = new ArrayList<>();
        IntStream.range(0, NUMBER_LENGTH)
                .forEach(index -> threeBalls.add(new Baseball(inputNumbers[index], index)));
    }


    public List<BallStatus> compareThreeBall(Baseballs another) {
        return threeBalls.stream()
                .map(another::compareBall)
                .collect(Collectors.toList());
    }

    private BallStatus compareBall(Baseball anotherBall) {
        return threeBalls.stream()
                .map(anotherBall::judgeBallStatus)
                .filter(ballStatus -> ballStatus == BallStatus.BALL || ballStatus == BallStatus.STRIKE)
                .findAny()
                .orElse(BallStatus.NOTHING);
    }
}
