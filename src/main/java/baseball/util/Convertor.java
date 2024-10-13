package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    private Convertor(){

    }
    public static List<Integer> convertList(String value){
        List<Integer> result = new ArrayList<>();
        String[] values = value.split(",");

        for (String s : values) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
