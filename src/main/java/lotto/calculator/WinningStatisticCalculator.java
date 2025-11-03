package lotto.calculator;

import static lotto.global.LottoConstant.PRICE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;
import lotto.calculator.dto.LottosDto;
import lotto.calculator.dto.WinningInfoDto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.global.WinningPrize;

public class WinningStatisticCalculator {

    private static final int TO_PERCENT = 100;

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningStatisticCalculator(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningInfoDto calculateWinningStatistic(LottosDto dto) {
        Map<WinningPrize, Integer> winningPrizes = initializeWinningPrizes();
        countWinningLottos(dto, winningPrizes);
        BigDecimal winningRate = calculateWinningRate(winningPrizes, dto.lottos().size());

        return new WinningInfoDto(winningPrizes, winningRate);
    }

    private Map<WinningPrize, Integer> initializeWinningPrizes() {
        Map<WinningPrize, Integer> winningPrizes = new EnumMap<>(WinningPrize.class);
        for (WinningPrize prize : WinningPrize.values()) {
            winningPrizes.put(prize, 0);
        }
        return winningPrizes;
    }

    private void countWinningLottos(LottosDto dto, Map<WinningPrize, Integer> winningPrizes) {
        dto.lottos().forEach(lotto -> {
            WinningPrize prize = determineWinningPrize(lotto);
            if (prize != null) {
                winningPrizes.put(prize, winningPrizes.get(prize) + 1);
            }
        });
    }

    private WinningPrize determineWinningPrize(Lotto lotto) {
        int matchingNumbers = lotto.countMatchingNumbers(winningNumber);
        boolean hasBonusNumber = lotto.containsBonusNumber(bonusNumber);

        return WinningPrize.findByCondition(matchingNumbers, hasBonusNumber)
                .orElse(null);
    }

    private BigDecimal calculateWinningRate(Map<WinningPrize, Integer> winningPrizes, int totalLottos) {
        int totalPrize = calculateTotalPrize(winningPrizes);
        int totalCost = totalLottos * PRICE.getValue();

        return convertToPercentage(totalPrize, totalCost);
    }

    private int calculateTotalPrize(Map<WinningPrize, Integer> winningPrizes) {
        int totalPrize = 0;
        for (Map.Entry<WinningPrize, Integer> entry : winningPrizes.entrySet()) {
            WinningPrize prize = entry.getKey();
            int count = entry.getValue();
            totalPrize += prize.getPrize() * count;
        }
        return totalPrize;
    }

    private BigDecimal convertToPercentage(int totalPrize, int totalCost) {
        return BigDecimal.valueOf(totalPrize)
                .divide(BigDecimal.valueOf(totalCost), 3, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(TO_PERCENT));
    }
}
