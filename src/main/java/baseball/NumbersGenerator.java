package baseball;

import static baseball.constants.Game.MAX_NUMBER;
import static baseball.constants.Game.MIN_NUMBER;
import static baseball.constants.Game.NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumbersGenerator {

    public Numbers randomNumberGenerate() {
        Numbers numbers = new Numbers();
        while (numbers.size() < NUMBERS_SIZE) {
            Number randomNumber = new Number(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER), numbers.size());
            if (!numbers.isContains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public Numbers inputNumbersGenerate(String input) {
        List<Integer> inputNumbers = input.chars()
            .mapToObj(str -> Character.getNumericValue(str)).toList();

        Numbers numbers = new Numbers();
        inputNumbers.forEach(num -> {
            numbers.add(new Number(num,numbers.size()));
        });

        return numbers;
    }
}
