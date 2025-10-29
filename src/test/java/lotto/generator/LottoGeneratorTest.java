package lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    private LottoGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new LottoGenerator();
    }

    //TODO: 로또 가격이 달라질 때 테스트가 깨지게 됨.
    // 이를 고려한 테스트 코드 재작성이 필요

    @Test
    @DisplayName("로또 구입금액이 로또 1개 가격으로 나눠떨어지지 않는다면 예외를 발생시킨다.")
    void failGenerateLotto() {
        // given
        final int money = 12500;

        // when & then
        assertThatThrownBy(() -> generator.generateLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 가격이 맞아 떨어지지 않습니다.");
    }

    @Test
    @DisplayName("로또 구입금액을 로또 1개 가격으로 나눈 수만큼의 로또를 생성한다.")
    void generateLotto() {
        //given
        final int money = 3000;

        //when
        List<Lotto> lottos = generator.generateLotto(money);

        //then
        assertThat(lottos).hasSize(3);
    }
}
