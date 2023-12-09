package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리여야 합니다.");
        }

        Set<LottoNumber> duplicacy = new HashSet<>(numbers);
        if (duplicacy.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
        }
    }


}
