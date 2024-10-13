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


}
