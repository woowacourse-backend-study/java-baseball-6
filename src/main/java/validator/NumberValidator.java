package validator;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Validator;

import java.util.HashSet;
import java.util.Set;

import static com.oracle.graal.compiler.enterprise.c.v;

public class NumberValidator implements Validator{


    @Override
    public void validate(String value) {
        validType(value);
        validLength(value);
        validRange(value);
    }

    //타입이 잘못 입력된 경우
    private void validType(String value) throws IllegalAccessException {
        try{
            Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new IllegalAccessException("잘못된 숫자 입력입니다.")
        }

    }
    //3이라는 길이가 벗어난 입력
    private void validLength(String value){
        String[] splitValues = value.split("");
        Set<String> temp = new HashSet<>();
        for (String v : splitValues) {
            temp.add(v);
        }
        if (temp.size() != 3 || value.length() != 3) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    //1~9라는 범위에 벗어난 입력
    private void validRange(String value){String[] splitValues = value.split("");
        for (String v : splitValues) {
            int number = Integer.parseInt(v);
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
            }
        }
    }
}
