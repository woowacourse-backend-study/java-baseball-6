package baseball;

import static baseball.constants.Input.INPUT_GAME_OPTION_MESSAGE;
import static baseball.constants.Input.RESTART_GAME_OPTION;
import static baseball.view.Input.printInputGameOption;

public class GameManager {
    private final BaseballGame baseballGame = new BaseballGame();

    public void generateGame() {
        try {

            baseballGame.start();
            String input = printInputGameOption(INPUT_GAME_OPTION_MESSAGE);

            if (input.equals(RESTART_GAME_OPTION)) {
                generateGame();
            }

        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
