package baseball;

import static baseball.constants.Input.END_GAME_OPTION;
import static baseball.constants.Input.INPUT_GAME_OPTION_MESSAGE;
import static baseball.view.Input.printInputGameOption;

public class GameManager {
    private final BaseballGame baseballGame = new BaseballGame();

    public void generateGame() {
        while(true) {
            baseballGame.start();
            String input = printInputGameOption(INPUT_GAME_OPTION_MESSAGE);

            if (input.equals(END_GAME_OPTION)) {
                break;
            }
        }
    }
}
