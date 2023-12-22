package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, LottoNumber bonus) {
        return new WinningLotto(winningLotto, bonus);
    }

    public Rank countWinningNumber(Lotto other) {
        int count = winningLotto.match(other);
        boolean hasBonus = other.isContain(this.bonusNumber);

        return Rank.find(count, hasBonus);
    }

    private void validate(Lotto winningLotto, LottoNumber lottoNumber) {
        if (winningLotto.isContain(lottoNumber)) {
            throw new IllegalArgumentException("[eror]");
        }
    }
}
