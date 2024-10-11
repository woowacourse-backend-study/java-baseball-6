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

        int select;
        try {
            select = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_CONTINUE_OR_EXIT);
        }

        if (select != State.CONTINUE && select != State.EXIT) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_CONTINUE_OR_EXIT);
        }

        return select;
    }
}
