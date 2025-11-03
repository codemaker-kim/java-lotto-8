package lotto.calculator.dto;

import java.math.BigDecimal;
import java.util.Map;
import lotto.global.WinningPrize;

public record WinningInfoDto(
        Map<WinningPrize, Integer> winningPrizes,
        BigDecimal winningRate
) {
}
