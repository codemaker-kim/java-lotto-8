package lotto.calculator;

public enum WinningPrize {

    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    final int prize;

    WinningPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
