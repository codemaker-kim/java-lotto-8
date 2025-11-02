package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottosTest {

    @ParameterizedTest
    @DisplayName("객체 생성 시의 인자가 비어있으면 예외가 발생한다.")
    @NullAndEmptySource
    void emptyParameter(List<Lotto> parameter) throws Exception {
        // assert
        assertThatThrownBy(() -> Lottos.from(parameter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 목록이 비어있으면 안 됩니다.");
    }
}
