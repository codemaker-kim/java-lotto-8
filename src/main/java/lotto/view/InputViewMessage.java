package lotto.view;

public enum InputViewMessage {
    MONEY_INPUT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요.");

    final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
