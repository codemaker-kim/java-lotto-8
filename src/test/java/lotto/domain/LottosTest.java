package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottosTest {

    private static final int ASSERT_NUMBER_SIZE = 4;

    @ParameterizedTest
    @DisplayName("객체 생성 시의 인자가 비어있으면 예외가 발생한다.")
    @NullAndEmptySource
    void emptyParameter(List<Lotto> parameter) throws Exception {
        // assert
        assertThatThrownBy(() -> Lottos.from(parameter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 목록이 비어있으면 안 됩니다.");
    }

    @Test
    @DisplayName("로또 번호 목록을 정상적으로 반환한다.")
    void getLottoNumbers() {
        // given
        List<Lotto> lottoList = createLottoList();
        Lottos lottos = Lottos.from(lottoList);

        // when
        List<String> result = lottos.getLottoNumbers();

        // then
        assertThat(result).hasSize(ASSERT_NUMBER_SIZE)
                .containsExactly(
                        "[1, 2, 3, 4, 5, 6]",
                        "[2, 3, 4, 5, 6, 7]",
                        "[3, 4, 5, 6, 7, 8]",
                        "[4, 5, 6, 7, 8, 9]"
                );
    }

    private List<Lotto> createLottoList() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < ASSERT_NUMBER_SIZE; i++) {
            lottoList.add(createLotto(i));
        }
        return lottoList;
    }

    private Lotto createLotto(int offset) {
        return new Lotto(List.of(
                1 + offset,
                2 + offset,
                3 + offset,
                4 + offset,
                5 + offset,
                6 + offset
        ));
    }
}
