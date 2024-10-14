package baseball;

import static baseball.Input.printInputGameOption;

public class GameManager {
    private final BaseballGame baseballGame = new BaseballGame();

    public void generateGame() {
        try {

            baseballGame.start();
            String input = printInputGameOption("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if (input.equals("1")) {
                generateGame();
            }

        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
