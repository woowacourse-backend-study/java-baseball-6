package baseball;

import static baseball.Input.printInputNumberMessage;
import static baseball.Output.printMessage;

public class BaseballGame {

    private boolean gameStatus = false;

    public void start() {
        printMessage("숫자 야구 게임을 시작합니다.");
        Referee referee = new Referee();

        NumbersGenerator numbersGenerator = new NumbersGenerator();
        Numbers gameNumbers = numbersGenerator.randomNumberGenerate();
        System.out.println(gameNumbers);

        do {
            referee.init();

            String inputNumber = printInputNumberMessage("숫자를 입력해주세요 : ");
            Numbers inputNumbers = numbersGenerator.inputNumbersGenerate(inputNumber);

            referee.judge(gameNumbers, inputNumbers);

            gameStatus = referee.checkGameResult();
            referee.generateHint();
        }
        while (!gameStatus);

        printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
