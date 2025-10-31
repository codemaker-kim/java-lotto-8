package lotto.generator;

import static lotto.generator.LottoConstant.MAXIMUM_NUMBER;
import static lotto.generator.LottoConstant.MINIMUM_NUMBER;
import static lotto.generator.LottoConstant.PRICE;
import static lotto.generator.LottoConstant.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {

    private final int ZERO = 0;

    public List<Lotto> generateLotto(int money) {
        validateMoneyDivisibleByPrice(money);
        validateMoneyNotZero(money);

        List<Lotto> lottos = new ArrayList<>();

        int lottoCount = money / PRICE.getValue();
        for (int i = ZERO; i < lottoCount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private void validateMoneyDivisibleByPrice(int money) {
        if (money % PRICE.getValue() != ZERO) {
            throw new IllegalArgumentException("[ERROR] 로또 가격이 맞아 떨어지지 않습니다. 로또 하나 가격: " + PRICE.getValue());
        }
    }

    private void validateMoneyNotZero(int money) {
        if (money == ZERO) {
            throw new IllegalArgumentException("[ERROR] 로또는 최소한 하나는 구매해야 합니다.");
        }
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MINIMUM_NUMBER.getValue(),
                MAXIMUM_NUMBER.getValue(),
                SIZE.getValue()
        );

        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
