package lotto.handler;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.generator.BonusNumberGenerator;
import lotto.validator.BonusNumberInputValidator;
import lotto.view.LottoInputView;

public class BonusNumberHandler {

    private final BonusNumberInputValidator validator;
    private final BonusNumberGenerator generator;

    public BonusNumberHandler(BonusNumberInputValidator validator, BonusNumberGenerator generator) {
        this.validator = validator;
        this.generator = generator;
    }

    public BonusNumber getBonusNumber(List<Integer> winningNumber) {
        String bonusNumberInput = LottoInputView.getBonusNumberInput();
        validator.validate(bonusNumberInput);

        int bonusNumber = Integer.parseInt(bonusNumberInput);

        return generator.generateBonusNumber(bonusNumber, winningNumber);
    }
}
