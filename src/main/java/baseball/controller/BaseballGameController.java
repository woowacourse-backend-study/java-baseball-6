package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.StartView;
import domain.Balls;
import domain.GameResult;

public class BaseballGameController {
    public void run() {
        StartView.startComment();
        Balls computerBalls = new Balls();

        String inputNumbers = InputView.inputNumbers();
        Balls userBalls = new Balls(inputNumbers);

        GameResult gameResult = new GameResult(computerBalls, userBalls);
        OutputView.gameResult(gameResult);
    }
}
