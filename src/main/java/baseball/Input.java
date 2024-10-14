package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    public static String printInputNumberMessage(String message) {
        String input = printInputMessage(message);
        validateInputNumber(input);
        return input;
    }

    public static String printInputGameOption(String message) {
        String input = printInputMessage(message);
        validateInputGameOption(input);
        return input;
    }

    public static String printInputMessage(String message) {
        System.out.print(message);
        System.out.println();
        return readLine();
    }

    private static void validateInputNumber(String input) {
        if(!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
        }
    }

    private static void validateInputGameOption(String input) {
        if(!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
        }
    }
}
