package lotto.controller;

import java.util.List;
import lotto.calculator.WinningStatisticCalculator;
import lotto.calculator.dto.LottosDto;
import lotto.calculator.dto.WinningInfoDto;
import lotto.config.AppConfig;
import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.handler.BonusNumberHandler;
import lotto.handler.LottoHandler;
import lotto.handler.WinningNumberHandler;
import lotto.view.LottoOutputView;
import lotto.view.dto.LottoStringDto;

public class LottoController {

    private final LottoHandler lottoHandler;
    private final WinningNumberHandler winningNumberHandler;
    private final BonusNumberHandler bonusNumberHandler;

    public LottoController(AppConfig appConfig) {
        this.lottoHandler = appConfig.lottoHandler();
        this.winningNumberHandler = appConfig.winningNumberHandler();
        this.bonusNumberHandler = appConfig.bonusNumberHandler();
    }

    public void run() {
        while (true) {
            try {
                Lottos lottos = getLottos();

                WinningNumber winningNumber = getWinningNumber();

                BonusNumber bonusNumber = getBonusNumber(winningNumber);

                calculateAndDisplayResults(lottos, winningNumber, bonusNumber);
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos getLottos() {
        Lottos lottos = lottoHandler.getLottos();
        displayLottos(lottos.getLottoNumbers());

        return lottos;
    }

    private void displayLottos(List<String> lottoNumbers) {
        LottoOutputView.lottoCountView(lottoNumbers.size());
        LottoStringDto lottoView = new LottoStringDto(lottoNumbers);
        LottoOutputView.lottoView(lottoView);
    }

    private WinningNumber getWinningNumber() {
        return winningNumberHandler.getWinningNumber();
    }

    private BonusNumber getBonusNumber(WinningNumber winningNumber) {
        return bonusNumberHandler.getBonusNumber(winningNumber.getNumbers());
    }

    private void calculateAndDisplayResults(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningInfoDto winningInfo = calculateWinningStatistics(lottos, winningNumber, bonusNumber);
        displayResults(winningInfo);
    }

    private WinningInfoDto calculateWinningStatistics(Lottos lottos, WinningNumber winningNumber,
                                                      BonusNumber bonusNumber) {
        WinningStatisticCalculator calculator = new WinningStatisticCalculator(winningNumber, bonusNumber);
        LottosDto lottosDto = new LottosDto(lottos.getLottos());

        return calculator.calculateWinningStatistic(lottosDto);
    }

    private void displayResults(WinningInfoDto winningInfo) {
        LottoOutputView.statisticView(winningInfo.winningPrizes());
        LottoOutputView.rateView(winningInfo.winningRate().doubleValue());
    }
}
