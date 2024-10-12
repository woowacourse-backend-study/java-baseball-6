package domain;

import baseball.constant.Condition;
import baseball.constant.Message;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private List<Integer> balls;

    public Balls() {
        balls = new ArrayList<>();

        while (balls.size() < Condition.TOTAL_BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Condition.MIN_BALL_NUMBER, Condition.MAX_BALL_NUMBER);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }
    }

    public Balls(String inputNumbers) {
        balls = Arrays.stream(inputNumbers.split(""))
                .mapToInt(this::convertCharToInt)
                .boxed()
                .collect(Collectors.toList());

        checkInputNumberLength();
        checkInputNumberRange();
        checkInputNumberDuplicate();
    }

    private int convertCharToInt(String ch) {
        try {
            return Integer.parseInt(ch);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_BALL_ONLY_NUMBERS);
        }
    }

    private void checkInputNumberLength() {
        if (balls.size() != Condition.TOTAL_BALL_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_BALL_NUMBERS_LENGTH);
        }
    }

    private void checkInputNumberRange() {
        if (balls.stream().anyMatch(n -> n < Condition.MIN_BALL_NUMBER || n > Condition.MAX_BALL_NUMBER)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_BALL_NUMBERS_RANGE);
        }
    }

    private void checkInputNumberDuplicate() {
        if (balls.stream().distinct().count() != Condition.TOTAL_BALL_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_BALL_DUPLICATE);
        }
    }

    public boolean isSameByPosition(Balls compareBalls, int position) {
        return this.balls.get(position).equals(compareBalls.balls.get(position));
    }

    public boolean isContain(Balls userBalls, Integer i) {
        return this.balls.contains(userBalls.balls.get(i));
    }
}
