package validator;

import java.util.HashSet;
import java.util.Set;

public class NumberValidator implements Validator {

    @Override
    public void validate(String value) {
        validType(value);
        validLength(value);
        validRange(value);
    }

    // 숫자 타입 검증
    private void validType(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    // 길이 검증 (3자리 숫자 여부)
    private void validLength(String value) {
        String[] splitValues = value.split("");
        Set<String> temp = new HashSet<>();
        for (String v : splitValues) {
            temp.add(v);
        }
        if (temp.size() != 3 || value.length() != 3) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    // 숫자 범위 검증 (1~9 사이의 값)
    private void validRange(String value) {
        String[] splitValues = value.split("");
        for (String v : splitValues) {
            int number = Integer.parseInt(v);
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
            }
        }
    }
}