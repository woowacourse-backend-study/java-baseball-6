package baseball.controller;

import baseball.service.ScoreCalculator;
import baseball.util.RandomNumbersMaker;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private final OutputView outputView;
    private final InputView inputView;

    private ScoreCalculator scoreCalculator;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;

    }
    public void app(){
        outputView.printStartMessage();
        List<Integer> computer = RandomNumbersMaker.maker();
        System.out.println("computer = " + computer);
        String getNumber = String.valueOf(inputView.getGuessNumber());

        //List<Integer> computer
    }
}
