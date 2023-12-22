package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    public static Lotto from(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public boolean isContain(LottoNumber otherLottoNumber) {
        return lotto.contains(otherLottoNumber);
    }

    public int match(Lotto other) {
        return (int) this.lotto.stream()
                .filter(lottoNumber -> other.isContain(lottoNumber))
                .count();
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리여야 합니다.");
        }

        if (6 != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getLottoNumber() {
        return this.lotto.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

}
