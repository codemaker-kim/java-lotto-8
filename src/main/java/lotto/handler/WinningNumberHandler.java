package lotto.handler;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningNumber;
import lotto.generator.WinningNumberGenerator;
import lotto.validator.WinningNumberInputValidator;
import lotto.view.LottoInputView;

public class WinningNumberHandler {

    private static final String COMMA = ",";

    private final WinningNumberGenerator generator;
    private final WinningNumberInputValidator validator;

    public WinningNumberHandler(WinningNumberGenerator generator, WinningNumberInputValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public WinningNumber getWinningNumber() {
        String input = LottoInputView.getWinningNumberInput();
        validator.validate(input);

        List<Integer> winningNumbers = Arrays.stream(input.split(COMMA))
                .map(Integer::parseInt)
                .toList();

        return generator.generateWinningNumber(winningNumbers);
    }
}
