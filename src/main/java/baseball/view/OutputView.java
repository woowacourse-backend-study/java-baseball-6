package baseball.view;

import baseball.constant.Message;
import domain.GameResult;

public class OutputView {
    public static void gameResult(GameResult gameResult) {
        System.out.println(gameResult.toString());
    }

    public static void gameEnd() {
        System.out.println(Message.GAME_END);
    }
}
