package baseball;

import static baseball.constants.Game.BALL;
import static baseball.constants.Game.BALL_HINT;
import static baseball.constants.Game.END_GAME_COUNT;
import static baseball.constants.Game.NOTHING;
import static baseball.constants.Game.STRIKE;
import static baseball.constants.Game.STRIKE_BALL_HINT;
import static baseball.constants.Game.STRIKE_HINT;

import java.util.HashMap;
import java.util.Map;

public class Referee {

    private Map<String,Integer> countResult = new HashMap<>();

    public Referee() {
        init();
    }

    public void judge(Numbers gameNumbers, Numbers inputNumbers) {
        for (Number number : inputNumbers.getNumbers()) {
            if (gameNumbers.isContains(number) && number.checkIndex(gameNumbers.indexOf(number))) {
                countResult.put(STRIKE, countResult.get(STRIKE) + 1) ;
            } else if (gameNumbers.isContains(number) && !number.checkIndex(gameNumbers.indexOf(number))) {
                countResult.put(BALL, countResult.get(BALL) + 1) ;
            }
        }
    }

    public boolean checkGameResult() {
        return countResult.get(STRIKE) == END_GAME_COUNT && countResult.get(BALL) == 0;
    }

    public void generateHint() {

        if(countResult.get(STRIKE) != 0 && countResult.get(BALL) == 0) {
            System.out.printf(STRIKE_HINT,countResult.get(STRIKE));
            System.out.println();
            return;
        }

        if(countResult.get(STRIKE) == 0 && countResult.get(BALL) != 0) {
            System.out.printf(BALL_HINT,countResult.get(BALL));
            System.out.println();
            return;
        }

        if(countResult.get(STRIKE) != 0 && countResult.get(BALL) != 0) {
            System.out.printf(STRIKE_BALL_HINT,countResult.get(STRIKE),countResult.get(BALL));
            System.out.println();
            return;
        }

        if(countResult.get(STRIKE) == 0 && countResult.get(BALL) == 0) {
            System.out.println(NOTHING);
            System.out.println();
        }
    }

    public void init() {
        countResult.put(STRIKE,0) ;
        countResult.put(BALL,0) ;
    }
}
