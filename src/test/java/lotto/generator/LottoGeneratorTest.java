package lotto.generator;

import static lotto.generator.LottoConstant.PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static final int ASSERT_LOTTO_SIZE = 5;
    private static final int MINIMUM_LOTTO_PRICE = 1;
    private static final int ZERO = 0;
    private LottoGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new LottoGenerator();
    }

    @Test
    @DisplayName("로또 구입금액이 로또 1개 가격으로 나눠떨어지지 않는다면 예외를 발생시킨다.")
    void failGenerateLotto() {
        // given
        final int money = PRICE.getValue() - MINIMUM_LOTTO_PRICE;

        // when & then
        assertThatThrownBy(() -> generator.generateLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 가격이 맞아 떨어지지 않습니다.");
    }

    @Test
    @DisplayName("로또 구입금액이 0원이라면 예외를 발생시킨다.")
    void moneyInputIsZero() {
        // given
        final int money = ZERO;

        // when & then
        assertThatThrownBy(() -> generator.generateLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 최소한 하나는 구매해야 합니다.");
    }


    @Test
    @DisplayName("로또 구입금액을 로또 1개 가격으로 나눈 수만큼의 로또를 생성한다.")
    void generateLotto() {
        //given
        final int money = PRICE.getValue() * ASSERT_LOTTO_SIZE;

        //when
        List<Lotto> lottos = generator.generateLotto(money);

        //then
        assertThat(lottos).hasSize(ASSERT_LOTTO_SIZE);
    }
}
