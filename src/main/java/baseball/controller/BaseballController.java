package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    final OutputView outputView;
    final InputView inputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;

    }
    public void app(){
        outputView.printStartMessage();
    }
}
