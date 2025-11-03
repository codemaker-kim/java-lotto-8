package lotto.global;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPrize {

    FIFTH(3, 5_000, null),
    FOURTH(4, 50_000, null),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, null);

    final int matchCount;
    final int prize;
    private final Boolean bonusRequired;

    WinningPrize(int matchCount, int prize, Boolean bonusRequired) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusRequired = bonusRequired;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Optional<WinningPrize> findByCondition(int matchingNumbers, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(prize -> prize.matches(matchingNumbers, hasBonusNumber))
                .findFirst();
    }

    private boolean matches(int matchingNumbers, boolean hasBonusNumber) {
        if (this.matchCount != matchingNumbers) {
            return false;
        }

        if (this.bonusRequired == null) {
            return true;
        }

        return this.bonusRequired == hasBonusNumber;
    }
}
