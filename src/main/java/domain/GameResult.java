package domain;

import java.util.stream.Stream;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(Balls computerBalls, Balls userBalls) {
        strike = countStrike(computerBalls, userBalls);
        ball = countContain(computerBalls, userBalls) - strike;
    }

    private int countStrike(Balls computerBalls, Balls userBalls) {
        return (int) Stream.iterate(0, i -> i + 1).limit(3)
                .filter(i -> computerBalls.isSameByPosition(userBalls, i))
                .count();
    }

    private int countContain(Balls computerBalls, Balls userBalls) {
        return (int) Stream.iterate(0, i -> i + 1).limit(3)
                .filter(i -> computerBalls.isContain(userBalls, i))
                .count();
    }

    public boolean isAnswer() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
