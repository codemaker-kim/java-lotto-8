package lotto.calculator.dto;

import java.util.List;
import lotto.domain.Lotto;

public record LottosDto(
        List<Lotto> lottos
) {
}
