package lotto.global;

public enum LottoConstant {
    PRICE(1000),
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    SIZE(6);

    final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
