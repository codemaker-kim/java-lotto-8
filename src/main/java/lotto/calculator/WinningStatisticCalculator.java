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
        Map<WinningPrize, Integer> winningPrizes = new EnumMap<>(WinningPrize.class);

        // 모든 등수를 0으로 초기화
        for (WinningPrize prize : WinningPrize.values()) {
            winningPrizes.put(prize, 0);
        }

        // 각 로또의 당첨 여부 확인
        dto.lottos().forEach(lotto -> {
            WinningPrize prize = determineWinningPrize(lotto);
            if (prize != null) {
                winningPrizes.put(prize, winningPrizes.get(prize) + 1);
            }
        });

        // 수익률 계산
        BigDecimal winningRate = calculateWinningRate(winningPrizes, dto.lottos().size());

        return new WinningInfoDto(winningPrizes, winningRate);
    }

    private WinningPrize determineWinningPrize(Lotto lotto) {
        int matchingNumbers = lotto.countMatchingNumbers(winningNumber);
        boolean hasBonusNumber = lotto.containsBonusNumber(bonusNumber);

        if (matchingNumbers == 6) {
            return WinningPrize.FIRST;
        }
        if (matchingNumbers == 5 && hasBonusNumber) {
            return WinningPrize.SECOND;
        }
        if (matchingNumbers == 5) {
            return WinningPrize.THIRD;
        }
        if (matchingNumbers == 4) {
            return WinningPrize.FOURTH;
        }
        if (matchingNumbers == 3) {
            return WinningPrize.FIFTH;
        }
        return null; // 당첨되지 않음
    }

    private BigDecimal calculateWinningRate(Map<WinningPrize, Integer> winningPrizes, int totalLottos) {
        int totalPrize = 0;

        for (Map.Entry<WinningPrize, Integer> entry : winningPrizes.entrySet()) {
            WinningPrize prize = entry.getKey();
            int count = entry.getValue();
            totalPrize += prize.getPrize() * count;
        }

        int totalCost = totalLottos * PRICE.getValue();

        return BigDecimal.valueOf(totalPrize)
                .divide(BigDecimal.valueOf(totalCost), 3, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(TO_PERCENT));
    }
}
