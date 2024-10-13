package baseball;

import java.util.HashMap;
import java.util.Map;

public class Referee {
    public Map<String,Integer> countResult = new HashMap<>();

    public Referee() {
        init();
    }

    public void judge(Numbers gameNumbers, Numbers inputNumbers) {
        for (Number number : inputNumbers.getNumbers()) {
            if (gameNumbers.isContains(number) && number.checkIndex(gameNumbers.indexOf(number))) {
                countResult.put("STRIKE", countResult.get("STRIKE") + 1) ;
            } else if (gameNumbers.isContains(number) && !number.checkIndex(gameNumbers.indexOf(number))) {
                countResult.put("BALL", countResult.get("BALL") + 1) ;
            }
        }
    }

    public boolean checkGameResult() {
        return countResult.get("STRIKE") == 3 && countResult.get("BALL") == 0;
    }

    public void generateHint() {

        if(countResult.get("STRIKE") != 0 && countResult.get("BALL") == 0) {
            System.out.printf("%s스트라이크",countResult.get("STRIKE"));
            System.out.println();
            return;
        }

        if(countResult.get("STRIKE") == 0 && countResult.get("BALL") != 0) {
            System.out.printf("%s볼",countResult.get("BALL"));
            System.out.println();
            return;
        }

        if(countResult.get("STRIKE") != 0 && countResult.get("BALL") != 0) {
            System.out.printf("%s볼 %s스트라이크",countResult.get("STRIKE"),countResult.get("BALL"));
            System.out.println();
            return;
        }

        if(countResult.get("STRIKE") == 0 && countResult.get("BALL") == 0) {
            System.out.println("낫싱");
            System.out.println();
        }
    }

    public Map<String, Integer> getCountResult() {
        return countResult;
    }

    public void init() {
        countResult.put("STRIKE",0) ;
        countResult.put("BALL",0) ;
    }

//    합이 0이면 -> 낫싱 -> 게임 계속 진행
//    합이 3 인데 0이 없으면 -> 3스트라이크 -> 게임 종료
//    합이 3이 인데 0이 있으면 -> 힌트 제공 -> 게임 계속 진행
//    합이 3보다 크면 -> 힌트 제공 -> 게임 계속 진행
//    합이 3보다 작으면 -> 힌트 제공 -> 게임 계속 진행
}