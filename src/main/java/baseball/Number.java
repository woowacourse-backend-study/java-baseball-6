package baseball;

import static baseball.constants.Error.NUMBER_RANGE_ERROR;
import static baseball.constants.Game.MAX_NUMBER;
import static baseball.constants.Game.MIN_NUMBER;

public class Number {
    private final int number;
    private final int index;

    public Number(int number, int index) {
        validRange(number);
        this.number = number;
        this.index = index;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSame(Number number) {
        return this.number == number.getNumber();
    }

    public boolean checkIndex(int index) {
        return this.index == index;
    }

    // 숫자 생성할때 검증 로직 제작
    private void validRange(int number) {
        if ( number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return;
        }
        throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
    }
}
