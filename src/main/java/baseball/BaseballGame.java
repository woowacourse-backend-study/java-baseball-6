package baseball;

import static baseball.Input.printInputMessage;
import static baseball.Output.printMessage;

public class BaseballGame {

    private boolean gameStatus = false;
    // 게임이 진행중인지 상태를 저장했다가 게임이 종료되면 상태가 변경된다
    // 이 상태를 게임 매니저가 보고있다가 게임이 종료되었다면 다시 실행할지 묻는다.

    public void start() {
        // 시작 안내 문구 출력
        printMessage("숫자 야구 게임을 시작합니다.");
        Referee referee = new Referee();

        NumbersGenerator numbersGenerator = new NumbersGenerator();
        Numbers gameNumbers = numbersGenerator.randomNumberGenerate();
        System.out.println(gameNumbers);

        do {
            referee.init();
            // 게임 번호 생성
            // 정답 번호 입력 문구 출력
            String inputNumber = printInputMessage("숫자를 입력해주세요 : ");
            Numbers inputNumbers = numbersGenerator.inputNumbersGenerate(inputNumber);
            System.out.println(inputNumbers);
            // 정답 번호 생성
            referee.judge(gameNumbers, inputNumbers);
            System.out.println(referee.getGameResult());
            System.out.println(referee.getCountResult());
            // 심판이 정답 판단
            // 결과 출력
            gameStatus = referee.getGameResult();
        }
        while (gameStatus);

        System.out.println("게임 완료");

        // 게임 종료 여부 판단
        // 게임 종료 시 -> 재시작, 종료 여부 입력 문구 출력
        // 게임 지속 시 -> 정답 번호 입력부터 다시 시작
    }

    public boolean isEnd() {
        return gameStatus;
    }
}
