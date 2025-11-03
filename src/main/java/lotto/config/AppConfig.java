package lotto.config;

import lotto.handler.BonusNumberHandler;
import lotto.handler.LottoHandler;
import lotto.handler.WinningNumberHandler;

public class AppConfig {

    public LottoHandler lottoHandler() {
        return new LottoHandler();
    }

    public BonusNumberHandler bonusNumberHandler() {
        return new BonusNumberHandler();
    }

    public WinningNumberHandler winningNumberHandler() {
        return new WinningNumberHandler();
    }
}
