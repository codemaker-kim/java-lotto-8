package lotto.view;

import java.util.Map;
import lotto.calculator.WinningPrize;
import lotto.view.dto.LottoStringDto;

public class LottoOutputView {
    public static void lottoCountView(int lottoCount) {
        String message = String.format("%d개를 구매했습니다.", lottoCount);

        System.out.println(message);
    }

    public static void lottoView(LottoStringDto dto) {
        dto.lottoNumbers()
                .forEach(System.out::println);
    }

    public static void statisticView(final Map<WinningPrize, Integer> winningPrizes) {
        System.out.println("당첨 통계\n---");

        for (WinningPrize prize : WinningPrize.values()) {
            printWinningStatistic(prize, winningPrizes.get(prize));
        }
    }

    private static void printWinningStatistic(WinningPrize prize, int count) {
        String message = String.format("%d개 일치 (%d원) - %d개",
                prize.getMatchCount(),
                prize.getPrize(),
                count
        );

        System.out.println(message);
    }

    public static void rateView(double rate) {
        String message = String.format("총 수익률은 %.2f%%입니다.", rate);

        System.out.println(message);
    }
}
