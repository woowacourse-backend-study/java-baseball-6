package baseball;

import static baseball.Input.printInputMessage;
import static baseball.Output.printMessage;

public class BaseballGame {


    public void start() {
        // 시작 안내 문구 출력
        printMessage("숫자 야구 게임을 시작합니다.");
        // 게임 번호 생성
        NumbersGenerator numbersGenerator = new NumbersGenerator();
        Numbers gameNumbers = numbersGenerator.randomNumberGenerate();
        System.out.println(gameNumbers);
        // 정답 번호 입력 문구 출력
        String inputNumber = printInputMessage("숫자를 입력해주세요 : ");
        Numbers inputNumbers = numbersGenerator.inputNumbersGenerate(inputNumber);
        System.out.println(inputNumbers);
        // 정답 번호 생성
        Referee referee = new Referee();
        referee.judge(gameNumbers, inputNumbers);
        System.out.println(referee.getGameResult());
        System.out.println(referee.getCountResult());
        // 심판이 정답 판단
        // 결과 출력
        // 게임 종료 여부 판단
        // 게임 종료 시 -> 재시작, 종료 여부 입력 문구 출력
        // 게임 지속 시 -> 정답 번호 입력부터 다시 시작
    }

    public void end() {

    }
}
