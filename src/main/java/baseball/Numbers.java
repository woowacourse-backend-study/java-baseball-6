package baseball;

import java.util.ArrayList;
import java.util.List;

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

    public int indexOf(Number number) {
        int index = 0;
        for (Number num : numbers) {
            if (num.isSame(number)) {
                return index;
            }
            index++;
        }
        return 0;
    }

    public void validNumbers(Number number) {
        validSize();
        validDuplication(number);
    }

    public void validSize() {
        if(numbers.size() >= 3) {
            throw new IllegalArgumentException();
        };
    }

    public void validDuplication(Number number) {
        if(numbers.stream().anyMatch(num -> num.isSame(number))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Numbers{" +
            "numbers=" + numbers +
            '}';
    }
}
