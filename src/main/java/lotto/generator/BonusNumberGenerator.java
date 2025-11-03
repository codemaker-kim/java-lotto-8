package lotto.generator;

import java.util.List;
import lotto.domain.BonusNumber;

public class BonusNumberGenerator {

    public BonusNumber generateBonusNumber(int number, List<Integer> winningNumbers) {
        validate(number, winningNumbers);

        return new BonusNumber(number);
    }

    private void validate(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalStateException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        if (isOverLottoRange(number)) {
            throw new IllegalStateException("[ERROR] 보너스 번호가 로또 숫자 범위에 포함되지 않습니다.");
        }
    }

    private boolean isOverLottoRange(int number) {
        return number > LottoConstant.MAXIMUM_NUMBER.getValue() ||
                number < LottoConstant.MINIMUM_NUMBER.getValue();
    }
}
