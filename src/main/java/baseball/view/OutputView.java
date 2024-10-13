package baseball.view;

public class OutputView {
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printResultMessage(int strike,int ball) {
        StringBuilder builder = new StringBuilder();

        if( ball==0 && strike==0){
            builder.append("낫싱");
        }
        if(ball>0){
            builder.append(ball);
            builder.append("볼 ");
        }
        if(strike>0){
            builder.append(strike);
            builder.append("스트라이크");
        }
        System.out.println(builder);
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
