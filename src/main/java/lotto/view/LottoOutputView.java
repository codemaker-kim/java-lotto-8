package lotto.view;

import java.util.Map;
import lotto.calculator.WinningPrize;
import lotto.view.dto.LottoStringDto;

public class LottoOutputView {
    public void lottoCountView(int lottoCount) {
        String message = String.format("%d개를 구매했습니다.", lottoCount);

        System.out.println(message);
    }

    public void lottoView(LottoStringDto dto) {
        dto.lottoNumbers()
                .forEach(System.out::println);
    }

    public void statisticView(final Map<WinningPrize, Integer> winningPrizes) {
        System.out.println("당첨 통계\n---");

        for (WinningPrize prize : WinningPrize.values()) {
            printWinningStatistic(prize, winningPrizes.get(prize));
        }
    }

    private void printWinningStatistic(WinningPrize prize, int count) {
        String message = String.format("%d개 일치 (%d원) - %d개",
                prize.getMatchCount(),
                prize.getPrize(),
                count
        );

        System.out.println(message);
    }
}
