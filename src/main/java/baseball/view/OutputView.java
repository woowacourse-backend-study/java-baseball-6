package baseball.view;

import domain.GameResult;

public class OutputView {
    public static void gameResult(GameResult gameResult) {
        System.out.println(gameResult.toString());
    }

    public static void gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
