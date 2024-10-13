package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConvertTest {

    @DisplayName("문자를 List<Integer>로 변환 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}, {1}")
    @MethodSource("parametersProvider")
    void checkConverter(String value, List<Integer> result) {
        assertThat(Converter.convertList(value)).isEqualTo(result);
    }

    static List<Arguments> parametersProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.arguments("123", List.of(1, 2, 3)));
        argumentsList.add(Arguments.arguments("987", List.of(9, 8, 7)));
        return argumentsList;
    }

}
