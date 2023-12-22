package lotto.domain;

import java.util.function.BiPredicate;
import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000, (matchingCount, hasBonus) -> matchingCount == 6),
    SECOND(5, 30_000_000, (matchingNumber, hasBonus) -> matchingNumber == 5 && hasBonus),
    THIRD(5, 1_500_000, (matchingNumber, hasBonus) -> matchingNumber == 5 && !hasBonus),
    FOURTH(4, 50_000, (matchingNumber, hasBonus) -> matchingNumber == 4),
    FIFTH(3, 5_000, (matchingNumber, hasBonus) -> matchingNumber == 3),
    NONE(0, 0, (matchingNumber, hasBonus) -> matchingNumber < 3 || matchingNumber > 6);

    private final int machingNumber;
    private final int prize;
    private final BiPredicate<Integer, Boolean> matchingResult;


    Rank(int machingNumber, int prize, BiPredicate<Integer, Boolean> matchingResult) {
        this.machingNumber = machingNumber;
        this.prize = prize;
        this.matchingResult = matchingResult;
    }

    public static Rank find(int machingNumber, boolean hasBonus) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.matchingResult.test(machingNumber, hasBonus))
                .findFirst()
    //            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 매칭 숫자는 6개입니다."));
                .orElse(NONE);
    }

    public int getMachingNumber() {
        return this.machingNumber;
    }

    public int getPrize() {
        return this.prize;
    }
}
