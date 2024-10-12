package domain;

import static org.junit.jupiter.api.Assertions.*;

import baseball.constant.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {
    @Test
    @DisplayName("유저가 입력한 숫자 개수가 3 초과면 에러를 던짐")
    void inputBallOverLengthErrorTest() {
        String userInput = "1234";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Balls(userInput));

        assertEquals(Message.ERROR_INPUT_BALL_NUMBERS_LENGTH, exception.getMessage());
    }

    @Test
    @DisplayName("유저가 입력한 숫자 개수가 3 미만이면 에러를 던짐")
    void inputBallUnderLengthErrorTest() {
        String userInput = "12";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Balls(userInput));

        assertEquals(Message.ERROR_INPUT_BALL_NUMBERS_LENGTH, exception.getMessage());
    }

    @Test
    @DisplayName("유저가 입력한 숫자 범위가 1 ~ 9 가 아니면 에러를 던짐")
    void inputBallNumberRangeErrorTest() {
        String userInput = "012";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Balls(userInput));

        assertEquals(Message.ERROR_INPUT_BALL_NUMBERS_RANGE, exception.getMessage());
    }

    @Test
    @DisplayName("유저가 입력한 숫자에 중복이 있으면 에러를 던짐")
    void inputBallNumberDuplicateErrorTest() {
        String userInput = "112";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Balls(userInput));

        assertEquals(Message.ERROR_INPUT_BALL_DUPLICATE, exception.getMessage());
    }

    @Test
    @DisplayName("유저가 입력에 숫자가 아닌 문자가 있으면 에러를 던짐")
    void inputBallNotNumberErrorTest() {
        String userInput = "12a";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Balls(userInput));

        assertEquals(Message.ERROR_INPUT_BALL_ONLY_NUMBERS, exception.getMessage());
    }
}