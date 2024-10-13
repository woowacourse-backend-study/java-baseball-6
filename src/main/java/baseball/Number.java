package baseball;

public class Number {
    private final int number;
    private final int index;

    public Number(int number, int index) {
        validRange(number);
        this.number = number;
        this.index = index;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSame(Number number) {
        return this.number == number.getNumber();
    }

    public boolean checkIndex(int index) {
        return this.index == index;
    }

    // 숫자 생성할때 검증 로직 제작
    public void validRange(int number) {
        if ( number >= 1 && number <= 9) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "["+ index + " , " + number + "]";
    }
}
