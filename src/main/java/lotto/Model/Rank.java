package lotto.Model;

import java.util.List;
import java.util.stream.Stream;

public enum Rank {
    NONE(0, false, 0, "0개 일치 (0원)"),
    FIFTH(3, false, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)");

    private static final int MATCHING_COUNTS_DISTINGUISH_SECOND_FROM_THIRD = 5;

    private final int countsOfMatchingLottoNumber;
    private final boolean bonusBall;
    private final int prize;
    private final String message;

    Rank(int countsOfMatchingLottoNumber, boolean bonusBall, int prize, String message) {
        this.countsOfMatchingLottoNumber = countsOfMatchingLottoNumber;
        this.bonusBall = bonusBall;
        this.prize = prize;
        this.message = message;
    }

    public static int getPrize(Rank rank) {
        return rank.prize;
    }

    public static String getMessage(Rank rank) {
        return rank.message;
    }

    public static Rank calculateWinningRank(Lotto randomLotto, WinningLotto winningLotto, Bonus bonus) {
        List<Integer> randomLottoNumbers = randomLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getWinningLotto().getNumbers();
        int matchingCounts = 0;
        boolean isMatchingBonus = false;

        for (int randomLottoNumber : randomLottoNumbers) {
            if (winningLottoNumbers.contains(randomLottoNumber)) {
                matchingCounts++;
            }
        }
        if (isDistinguishSecondFromThird(matchingCounts)) {
            isMatchingBonus = isSecondRank(randomLottoNumbers, bonus);
        }
        return getRank(matchingCounts, isMatchingBonus);
    }

    private static boolean isDistinguishSecondFromThird(int matchingCounts) {
        return matchingCounts == MATCHING_COUNTS_DISTINGUISH_SECOND_FROM_THIRD;
    }

    private static boolean isSecondRank(List<Integer> randomLottoNumbers, Bonus bonus) {
        return randomLottoNumbers.contains(bonus.getBonusNumber());
    }

    private static Rank getRank(int matchingCounts, boolean isMatchingBonus) {
        Rank[] ranks = Rank.values();
        return Stream.of(ranks)
                .filter(rank -> rank.countsOfMatchingLottoNumber == matchingCounts)
                .filter(rank -> rank.bonusBall == isMatchingBonus)
                .findAny()
                .orElse(NONE);
    }
}
