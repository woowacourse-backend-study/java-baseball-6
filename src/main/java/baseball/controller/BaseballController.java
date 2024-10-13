package baseball.controller;

import baseball.service.ScoreCalculator;
import baseball.util.Converter;
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

    public void app() {
        outputView.printStartMessage();
        List<Integer> computer = RandomNumbersMaker.maker();
        System.out.println("computer = " + computer);  // 디버깅용 출력
        String guessNumber = String.valueOf(inputView.getGuessNumber());
        List<Integer> player = Converter.convertList(guessNumber);

        this.scoreCalculator = new ScoreCalculator(player, computer);
        int strike = scoreCalculator.calculateStrike();
        int ball = scoreCalculator.calculateBall();
        outputView.printResultMessage(strike, ball);

    }
}
