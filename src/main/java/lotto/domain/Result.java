package lotto.domain;

import java.util.EnumMap;

public class Result {
    private final EnumMap<Rank, Integer> ranks;

    private Result(EnumMap<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public static Result from(EnumMap<Rank, Integer> ranks) {
        return new Result(ranks);
    }

    public long calculateWinningPrice() {
        long winningPrice = 0L;
        for (Rank rank : ranks.keySet()) {
            if (ranks.get(rank) != 0) {
                winningPrice += (long) rank.getPrize() * ranks.get(rank);
            }
        }
        return winningPrice;
    }

    public EnumMap<Rank, Integer> getRanks() {
        return ranks;
    }
}
