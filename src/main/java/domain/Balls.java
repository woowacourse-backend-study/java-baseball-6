package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private List<Integer> balls;

    public Balls() {
        balls = new ArrayList<>();

        while (balls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }
    }

    public Balls(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException("1 ~ 9를 이용한 3자리 숫자를 입력해 주세요");
        }

        balls = Arrays.stream(inputNumbers.split(""))
                .mapToInt(ch -> {
                    int number = 0;

                    try {
                        number = Integer.parseInt(ch);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("1 ~ 9를 이용한 3자리 숫자를 입력해 주세요");
                    }

                    if (number == 0) {
                        throw new IllegalArgumentException("1 ~ 9를 이용한 3자리 숫자를 입력해 주세요");
                    }

                    return number;
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
