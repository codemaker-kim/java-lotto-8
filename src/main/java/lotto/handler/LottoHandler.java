package lotto.handler;

import lotto.domain.Lottos;
import lotto.generator.LottoGenerator;
import lotto.validator.MoneyInputValidator;
import lotto.view.LottoInputView;

public class LottoHandler {

    private final MoneyInputValidator validator;
    private final LottoGenerator generator;

    public LottoHandler(MoneyInputValidator validator, LottoGenerator generator) {
        this.validator = validator;
        this.generator = generator;
    }

    public Lottos getLottos() {
        String moneyInput = LottoInputView.getMoneyInput();
        validator.validate(moneyInput);

        int money = Integer.parseInt(moneyInput);

        return generator.generateLotto(money);
    }
}
