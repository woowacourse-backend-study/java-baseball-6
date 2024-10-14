package baseball;

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

    public void validNumbers(Number number) {
        validSize();
        validDuplication(number);
    }

    public void validSize() {
        if(numbers.size() >= 3) {
            throw new IllegalArgumentException("게임에 이용되는 숫자는 3개입니다.");
        };
    }

    public void validDuplication(Number number) {
        if(numbers.stream().anyMatch(num -> num.isSame(number))) {
            throw new IllegalArgumentException("중복되는 숫자는 사용할 수 없습니다");
        }
    }

    @Override
    public String toString() {
        return "Numbers{" +
            "numbers=" + numbers +
            '}';
    }
}
