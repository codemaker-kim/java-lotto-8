package lotto.domain;

import static java.util.stream.IntStream.rangeClosed;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    @Test
    @DisplayName("중복되는 번호가 존재할 경우, 예외를 발생시킨다.")
    void duplicationNumber() throws Exception {
        // assert
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호에 중복되는 숫자가 존재합니다.");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 갯수가 6개가 아니라면 예외가 발생한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8, 9, 10})
    void invalidWinningNumberCount(int count) {
        //given
        List<Integer> numbers = rangeClosed(1, count).boxed()
                .toList();

        // when & then
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호는 6개여야 합니다.");
    }
}
