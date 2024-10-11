package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.StartView;
import domain.Balls;
import domain.GameResult;

public class BaseballGameController {
    public void run() {
        StartView.startComment();

        do {
            Balls computerBalls = new Balls();
            while (true) {

                String inputNumbers = InputView.inputNumbers();
                Balls userBalls = new Balls(inputNumbers);

                GameResult gameResult = new GameResult(computerBalls, userBalls);
                OutputView.gameResult(gameResult);

                if (gameResult.isAnswer()) {
                    OutputView.gameEnd();
                    break;
                }
            }
        } while (InputView.inputContinueOrExit() == 1);
    }
}
