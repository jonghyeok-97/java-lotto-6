package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
        validateRange(number);
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validateRange(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 번호는 1~45숫자 여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
