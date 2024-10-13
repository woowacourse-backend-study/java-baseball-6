package baseball.util;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersMaker {
    private RandomNumbersMaker() {
    }

    public static List<Integer> maker() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber= Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }

        }
        return computer;
    }
}
