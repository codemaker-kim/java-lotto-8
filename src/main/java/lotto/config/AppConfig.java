package lotto.config;

import lotto.generator.BonusNumberGenerator;
import lotto.generator.LottoGenerator;
import lotto.generator.WinningNumberGenerator;
import lotto.handler.BonusNumberHandler;
import lotto.handler.LottoHandler;
import lotto.handler.WinningNumberHandler;
import lotto.validator.BonusNumberInputValidator;
import lotto.validator.MoneyInputValidator;
import lotto.validator.WinningNumberInputValidator;

public class AppConfig {

    public LottoHandler lottoHandler() {
        return new LottoHandler(moneyInputValidator(), lottoGenerator());
    }

    public BonusNumberHandler bonusNumberHandler() {
        return new BonusNumberHandler(bonusNumberInputValidator(), bonusNumberGenerator());
    }

    public WinningNumberHandler winningNumberHandler() {
        return new WinningNumberHandler(winningNumberGenerator(), winningNumberInputValidator());
    }

    private MoneyInputValidator moneyInputValidator() {
        return new MoneyInputValidator();
    }

    private LottoGenerator lottoGenerator() {
        return new LottoGenerator();
    }

    private WinningNumberInputValidator winningNumberInputValidator() {
        return new WinningNumberInputValidator();
    }

    private WinningNumberGenerator winningNumberGenerator() {
        return new WinningNumberGenerator();
    }

    private BonusNumberInputValidator bonusNumberInputValidator() {
        return new BonusNumberInputValidator();
    }

    private BonusNumberGenerator bonusNumberGenerator() {
        return new BonusNumberGenerator();
    }
}
