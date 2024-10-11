package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static int inputContinueOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int select;
        try {
            select = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 또는 2 만 입력 가능합니다.");
        }

        if (select != 1 && select != 2) {
            throw new IllegalArgumentException("1 또는 2 만 입력 가능합니다.");
        }

        return select;
    }
}
