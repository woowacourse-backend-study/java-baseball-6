package domain;

import baseball.constant.Condition;
import baseball.constant.Message;
import java.util.stream.Stream;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(Balls computerBalls, Balls userBalls) {
        strike = countStrike(computerBalls, userBalls);
        ball = countContain(computerBalls, userBalls) - strike;
    }

    private int countStrike(Balls computerBalls, Balls userBalls) {
        return (int) Stream.iterate(0, i -> i + 1).limit(Condition.TOTAL_BALL_COUNT)
                .filter(i -> computerBalls.isSameByPosition(userBalls, i))
                .count();
    }

    private int countContain(Balls computerBalls, Balls userBalls) {
        return (int) Stream.iterate(0, i -> i + 1).limit(Condition.TOTAL_BALL_COUNT)
                .filter(i -> computerBalls.isContain(userBalls, i))
                .count();
    }

    public boolean isAnswer() {
        return strike == Condition.TOTAL_BALL_COUNT;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return Message.NOTHING;
        }

        if (strike == 0) {
            return ball + Message.BALL;
        }

        if (ball == 0) {
            return strike + Message.STRIKE;
        }

        return ball + Message.BALL + " " + strike + Message.STRIKE;
    }
}
