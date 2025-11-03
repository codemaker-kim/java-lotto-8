package lotto.view;

public enum OutputViewMessage {
    COUNT_VIEW("%d개를 구매했습니다."),
    STATISTIC_VIEW("당첨 통계\n---"),
    WINNING_VIEW("%d개 일치 (%,d원) - %d개"),
    SECOND_PRIZE_VIEW("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    RATE_VIEW("총 수익률은 %s%%입니다.");

    final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
