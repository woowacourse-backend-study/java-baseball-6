package baseball;

import static baseball.Input.printInputMessage;

public class GameManager {
    private final BaseballGame baseballGame = new BaseballGame();

    public void generateGame() {
        baseballGame.start();

        String input = printInputMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (input.equals("1")) {
            generateGame();
        }
    }

    public void closeGame() {

    }
}
