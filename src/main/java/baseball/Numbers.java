package baseball;

import static baseball.constants.Error.DUPLICATION_ERROR;
import static baseball.constants.Error.SIZE_ERROR;
import static baseball.constants.Game.NUMBERS_SIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Numbers {
    private final List<Number> numbers = new ArrayList<>();

    public void add(Number number) {
        validNumbers(number);
        numbers.add(number);
    }

    public int size() {
        return numbers.size();
    }

    public boolean isContains(Number number) {
        return numbers.stream().anyMatch(num -> num.isSame(number));
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public int indexOf(Number number) {
        return IntStream.range(0, numbers.size())
            .filter(i -> numbers.get(i).isSame(number))
            .findFirst()
            .orElse(-1);
    }

    private void validNumbers(Number number) {
        validSize();
        validDuplication(number);
    }

    private void validSize() {
        if(numbers.size() >= NUMBERS_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        };
    }

    private void validDuplication(Number number) {
        if(numbers.stream().anyMatch(num -> num.isSame(number))) {
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
    }
}
