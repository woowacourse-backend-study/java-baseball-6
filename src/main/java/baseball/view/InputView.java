package baseball.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    public int printGetNumber() {
        System.out.println("숫자를 입력해 주세요: ");
        return scanner.nextInt();
    }

}
