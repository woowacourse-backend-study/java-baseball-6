package baseball.controller;

import baseball.view.InputView;
import baseball.view.StartView;
import domain.Balls;

public class BaseballGameController {
    public void run() {
        StartView.startComment();
        Balls computerBalls = new Balls();

        String inputNumbers = InputView.inputNumbers();
        Balls userBalls = new Balls(inputNumbers);
    }
}