package lotto.view;

import static lotto.calculator.WinningPrize.*;

import java.text.DecimalFormat;
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

        for (WinningPrize prize : values()) {
            printWinningStatistic(prize, winningPrizes.get(prize));
        }
    }

    private static void printWinningStatistic(WinningPrize prize, int count) {
        String message = createWinningMessage(prize, count);
        System.out.println(message);
    }

    private static String createWinningMessage(WinningPrize prize, int count) {
        if (prize == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                    prize.getMatchCount(),
                    prize.getPrize(),
                    count);
        }

        return String.format("%d개 일치 (%,d원) - %d개",
                prize.getMatchCount(),
                prize.getPrize(),
                count
        );
    }

    public static void rateView(double rate) {
        DecimalFormat df = new DecimalFormat("#.##");
        String message = String.format("총 수익률은 %s%%입니다.", df.format(rate));

        System.out.println(message);
    }
}
