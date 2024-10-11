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
        checkInputNumberLength(inputNumbers);

        balls = Arrays.stream(inputNumbers.split(""))
                .mapToInt(ch -> {
                    int number = convertCharToInt(ch);
                    checkInputNumberRangeValid(number);
                    return number;
                })
                .boxed()
                .collect(Collectors.toList());
    }

    private void checkInputNumberLength(String inputNumbers) {
        if (inputNumbers.length() != Condition.TOTAL_BALL_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_BALL_NUMBERS);
        }
    }

    private void checkInputNumberRangeValid(int number) {
        if (number < Condition.MIN_BALL_NUMBER || number > Condition.MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_BALL_NUMBERS);
        }
    }

    private int convertCharToInt(String ch) {
        try {
            return Integer.parseInt(ch);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_BALL_NUMBERS);
        }
    }

    public boolean isSameByPosition(Balls compareBalls, int position) {
        return this.balls.get(position).equals(compareBalls.balls.get(position));
    }

    public boolean isContain(Balls userBalls, Integer i) {
        return this.balls.contains(userBalls.balls.get(i));
    }
}
