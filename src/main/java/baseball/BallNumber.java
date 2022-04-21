package baseball;

import java.util.Objects;

public class BallNumber {
    private static final int MIN_NO = 1;
    private static final int MAX_NO = 9;
    private int no;

    public BallNumber(int no) {
        if (no > MAX_NO || no < MIN_NO) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야 합니다.");
        }
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    public int getNo() {
        return no;
    }
}
