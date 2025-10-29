package lotto.generator;

import static java.math.BigDecimal.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> generateLotto(int money) {
        if (money % LOTTO_PRICE != ZERO.intValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 가격이 맞아 떨어지지 않습니다. 로또 하나 가격: " + LOTTO_PRICE);
        }

        List<Lotto> lottos = new ArrayList<>();

        for (int count = money / LOTTO_PRICE; count > ZERO.intValue(); count--) {
            lottos.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE))
            );
        }

        return lottos;
    }
}
