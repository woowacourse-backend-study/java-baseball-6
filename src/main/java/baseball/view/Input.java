package baseball.view;

import static baseball.constants.Error.INPUT_FORMAT_ERROR;
import static baseball.constants.Input.END_GAME_OPTION;
import static baseball.constants.Input.INPUT_NUMBER_REGEX;
import static baseball.constants.Input.RESTART_GAME_OPTION;
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
        if(!input.matches(INPUT_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
        }
    }

    private static void validateInputGameOption(String input) {
        if(!(input.equals(RESTART_GAME_OPTION) || input.equals(END_GAME_OPTION))) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
        }
    }
}
