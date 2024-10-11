package baseball;

import baseball.controller.BasballController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BasballController controller=new BasballController(new OutputView());
        controller.app();
    }
}
