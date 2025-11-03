package lotto.controller;

import lotto.config.AppConfig;
import lotto.handler.BonusNumberHandler;
import lotto.handler.LottoHandler;
import lotto.handler.WinningNumberHandler;

public class LottoController {

    private final LottoHandler lottoHandler;
    private final WinningNumberHandler winningNumberHandler;
    private final BonusNumberHandler bonusNumberHandler;

    public LottoController(AppConfig appConfig) {
        this.lottoHandler = appConfig.lottoHandler();
        this.winningNumberHandler = appConfig.winningNumberHandler();
        this.bonusNumberHandler =  appConfig.bonusNumberHandler();
    }

    public void run() {

    }
}
