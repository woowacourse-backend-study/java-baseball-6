package baseball.view;

import baseball.constant.Message;
import baseball.constant.State;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumbers() {
        System.out.print(Message.INPUT_BALL_NUMBERS);
        return Console.readLine();
    }

    public static int inputContinueOrExit() {
        System.out.println(Message.INPUT_CONTINUE_OR_EXIT);

        int input = convertStringToInt(Console.readLine());
        checkInputValid(input);

        return input;
    }

    private static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_CONTINUE_OR_EXIT);
        }
    }

    private static void checkInputValid(int input) {
        if (input != State.CONTINUE && input != State.EXIT) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_CONTINUE_OR_EXIT);
        }
    }
}
