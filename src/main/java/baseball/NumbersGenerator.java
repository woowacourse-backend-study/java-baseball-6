package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumbersGenerator {

    public Numbers randomNumberGenerate() {
        Numbers numbers = new Numbers();
        while (numbers.size() < 3) {
            Number randomNumber = new Number(Randoms.pickNumberInRange(1, 9));
            if (!numbers.isContains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public Numbers inputNumbersGenerate(String input) {
        if(!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException();
        }
        List<Integer> inputNumbers = input.chars()
            .mapToObj(str -> Character.getNumericValue(str)).toList();

        Numbers numbers = new Numbers();
        inputNumbers.forEach(num -> {
            numbers.add(new Number(num));
        });

        return numbers;
    }
}
