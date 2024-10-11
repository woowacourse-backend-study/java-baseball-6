package baseball;

public class GameManager {
    private final BaseballGame baseballGame = new BaseballGame();

    public void generateGame() {
        baseballGame.start();
    }

    public void closeGame() {

    }
}
