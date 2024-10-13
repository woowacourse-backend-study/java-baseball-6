package baseball.service;

import java.util.List;

public class ScoreCalculator {

    private final List<Integer> computer;
    private final List<Integer> player;


    public ScoreCalculator(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
    }

    public Integer calculateStrike() {
        int strikeCount = 0;
        for (int index = 0; index < computer.size(); index++) {
            // 같은 인덱스에서 값이 일치하면 스트라이크
            if (computer.get(index).equals(player.get(index))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public Integer calculateBall() {
        int ballCount = 0;
        for (int index = 0; index < player.size(); index++) {
            // 같은 숫자를 가지고 있지만 다른 자리에 위치하는 경우
            if (computer.contains(player.get(index)) && !player.get(index).equals(computer.get(index))) {
                ballCount++;
            }
        }
        return ballCount;
    }


}
