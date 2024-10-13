package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScoreCalculatorTest {

    @DisplayName("같은 수 같은 자리-> 스트라이크")
    @ParameterizedTest(name = "{index}{displayName} message= {0}, {1}, {2}")
    @MethodSource("parametersProvider")

    void checkCalculateStrike(List<Integer> computer, List<Integer> player, Integer strikeCount){

        ScoreCalculator scoreCalculator = new ScoreCalculator(computer, player);
        assertThat(scoreCalculator.calculateStrike()).isEqualTo(strikeCount);

    }

    static List<Arguments> parametersProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.arguments(List.of(1, 2, 3), List.of(2, 1, 3), 1));
        argumentsList.add(Arguments.arguments(List.of(4, 5, 6), List.of(4, 5, 6), 3));
        argumentsList.add(Arguments.arguments(List.of(9, 7, 2), List.of(2, 1, 8), 0));
        argumentsList.add(Arguments.arguments(List.of(5, 3, 8), List.of(1, 3, 8), 2));
        return argumentsList;

    }

    @DisplayName("다른 자리에 같은 숫자 -> 볼")
    @ParameterizedTest(name = "{index} {displayName} message= {0}, {1}, {2}")
    @MethodSource("ballParametersProvider")
    void checkCalculateBall(List<Integer> computer, List<Integer> player, Integer ballCount) {
        ScoreCalculator scoreCalculator = new ScoreCalculator(computer, player);
        assertThat(scoreCalculator.calculateBall()).isEqualTo(ballCount);
    }

    static List<Arguments> ballParametersProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.arguments(List.of(1, 2, 3), List.of(3, 1, 2), 3));
        argumentsList.add(Arguments.arguments(List.of(4, 5, 6), List.of(6, 4, 5), 3));
        argumentsList.add(Arguments.arguments(List.of(1, 2, 3), List.of(1, 3, 2), 2));
        return argumentsList;
    }



}
