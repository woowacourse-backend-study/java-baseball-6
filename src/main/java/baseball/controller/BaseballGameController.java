package baseball.controller;

import baseball.constant.State;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.StartView;
import domain.Balls;
import domain.GameResult;

public class BaseballGameController {
    public void run() {
        StartView.startComment();

        do {
            playRound();
        } while (InputView.inputContinueOrExit() == State.CONTINUE);
    }

    private void playRound() {
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
    }
}
