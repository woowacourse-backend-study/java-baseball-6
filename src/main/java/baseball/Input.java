package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static String printInputMessage(String message) {
        System.out.print(message);
        System.out.println();
        return readLine();
    }
}
