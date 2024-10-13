package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private Converter() {
    }

    public static List<Integer> convertList(String value) {
        List<Integer> result = new ArrayList<>();
        for (char c : value.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }
        return result;
    }
}