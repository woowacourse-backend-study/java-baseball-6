package baseball.controller;

import baseball.view.OutputView;

public class BasballController {
    private final OutputView outputView;

    public BasballController(OutputView outputView) {
        this.outputView = outputView;
    }
    public void app(){
        outputView.printStartMessage();
    }
}
