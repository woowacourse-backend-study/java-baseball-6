package baseball;

public class Number {
    private final int number;

    public Number(int number) {
        validRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSame(Number number) {
        return this.number == number.getNumber();
    }

    // 숫자 생성할때 검증 로직 제작
    public void validRange(int number) {
        if ( number > 0 && number < 10) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return ""+ number;
    }
}
