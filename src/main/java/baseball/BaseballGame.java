package baseball;

import static baseball.constants.Input.INPUT_NUMBER_MESSAGE;
import static baseball.constants.Output.END_MESSAGE;
import static baseball.constants.Output.START_MESSAGE;
import static baseball.view.Input.printInputNumberMessage;
import static baseball.view.Output.printMessage;

public class BaseballGame {

    private boolean gameStatus = false;

    public void start() {
        printMessage(START_MESSAGE);
        Referee referee = new Referee();

        NumbersGenerator numbersGenerator = new NumbersGenerator();
        Numbers gameNumbers = numbersGenerator.randomNumberGenerate();

        do {
            referee.init();

            String inputNumber = printInputNumberMessage(INPUT_NUMBER_MESSAGE);
            Numbers inputNumbers = numbersGenerator.inputNumbersGenerate(inputNumber);

            referee.judge(gameNumbers, inputNumbers);

            gameStatus = referee.checkGameResult();

            referee.generateHint();
        }

        while (!gameStatus);

        printMessage(END_MESSAGE);
    }
}
