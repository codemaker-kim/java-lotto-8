package lotto.calculator;

import static lotto.global.WinningPrize.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.calculator.dto.LottosDto;
import lotto.calculator.dto.WinningInfoDto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticCalculatorTest {

    private WinningStatisticCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new WinningStatisticCalculator(
                new WinningNumber(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );
    }

    @Test
    @DisplayName("당첨 여부를 올바르게 판별한다.")
    void calculateWinning() {
        // given
        LottosDto dto = new LottosDto(createLottoList());

        // when
        WinningInfoDto result = calculator.calculateWinningStatistic(dto);

        // then
        assertThat(result.winningPrizes()
                .get(FIRST))
                .isEqualTo(1);
        assertThat(result.winningPrizes()
                .get(SECOND))
                .isEqualTo(1);
        assertThat(result.winningPrizes()
                .get(THIRD))
                .isEqualTo(0);
        assertThat(result.winningPrizes()
                .get(FOURTH))
                .isEqualTo(1);
        assertThat(result.winningPrizes()
                .get(FIFTH))
                .isEqualTo(1);

        assertThat(result.winningRate().doubleValue()).isEqualTo(5.0751375E7);
    }

    private List<Lotto> createLottoList() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lottoList.add(createLotto(i));
        }
        return lottoList;
    }

    private Lotto createLotto(int offset) {
        return new Lotto(List.of(
                1 + offset,
                2 + offset,
                3 + offset,
                4 + offset,
                5 + offset,
                6 + offset
        ));
    }
}