package lotto.view;

import static lotto.global.WinningPrize.*;
import static lotto.view.OutputViewMessage.COUNT_VIEW;
import static lotto.view.OutputViewMessage.RATE_VIEW;
import static lotto.view.OutputViewMessage.SECOND_PRIZE_VIEW;
import static lotto.view.OutputViewMessage.STATISTIC_VIEW;
import static lotto.view.OutputViewMessage.WINNING_VIEW;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.global.WinningPrize;
import lotto.view.dto.LottoStringDto;

public class LottoOutputView {

    private static final String DEMICAL_FORMAT = "#.##";

    public static void lottoCountView(int lottoCount) {
        String message = String.format(
                COUNT_VIEW.getMessage(), lottoCount);

        System.out.println(message);
    }

    public static void lottoView(LottoStringDto dto) {
        dto.lottoNumbers()
                .forEach(System.out::println);
    }

    public static void statisticView(final Map<WinningPrize, Integer> winningPrizes) {
        System.out.println(STATISTIC_VIEW.getMessage());

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
            return String.format(
                    SECOND_PRIZE_VIEW.getMessage(),
                    prize.getMatchCount(),
                    prize.getPrize(),
                    count);
        }

        return String.format(
                WINNING_VIEW.getMessage(),
                prize.getMatchCount(),
                prize.getPrize(),
                count
        );
    }

    public static void rateView(double rate) {
        DecimalFormat df = new DecimalFormat(DEMICAL_FORMAT);

        String message = String.format(
                RATE_VIEW.getMessage(),
                df.format(rate)
        );

        System.out.println(message);
    }
}
