package baseball;

import baseball.util.RandomNumbersMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
class RandomNumbersGeneratorTest {
    @Test
    @DisplayName("중복된 숫자 제외 랜덤한 숫자 생성 테스트")
    void checkUniqueRandomNumbers() {
        List<Integer> computer = RandomNumbersMaker.maker();
        assertThat(Set.copyOf(computer).size()).isEqualTo(computer.size())
                .isEqualTo(3);
    }
    @Test
    @DisplayName("올바른 범위 숫자 생성 테스트")
    void checkValidRangeNumbers() {
        List<Integer> computer = RandomNumbersMaker.maker();
        assertThat(computer).allMatch(i -> 1 <= i && i <= 9);
    }
}