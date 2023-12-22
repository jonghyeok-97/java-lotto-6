package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGroup {
    private final List<Lotto> lottos;

    private LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGroup from(List<Lotto> lottos) {
        return new LottoGroup(lottos);
    }

    public Result calculate(WinningLotto winningLotto) {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
        for (Lotto lotto : this.lottos) {
            Rank rank = winningLotto.countWinningNumber(lotto);
            ranks.put(rank, ranks.get(rank) + 1);
        }
        return Result.from(ranks);
    }

    public List<List<Integer>> getLottos() {
        return this.lottos.stream()
                .map(Lotto::getLottoNumber)
                .collect(Collectors.toList());
    }
}
