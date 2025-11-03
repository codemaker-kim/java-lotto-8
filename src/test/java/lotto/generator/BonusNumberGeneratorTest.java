package lotto.generator;

import static lotto.generator.LottoConstant.MAXIMUM_NUMBER;
import static lotto.generator.LottoConstant.MINIMUM_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BonusNumberGeneratorTest {
    private BonusNumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new BonusNumberGenerator(List.of(3, 4, 5, 6, 7, 8));
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복된다면 예외를 발생시킨다.")
    void duplicateNumber() {
        // given
        final int number = 3;

        // when & then
        assertThatThrownBy(() -> generator.generateBonusNumber(number))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("invalidNumbers")
    @DisplayName("보너스 번호가 로또 숫자 범위에 포함되지 않는다면 예외를 발생시킨다.")
    void overLottoNumberRange(int number) {
        // when & then
        assertThatThrownBy(() -> generator.generateBonusNumber(number))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("보너스 번호가 로또 숫자 범위에 포함되지 않습니다.");
    }

    static Stream<Integer> invalidNumbers() {
        return Stream.of(
                MINIMUM_NUMBER.getValue() - 1,
                MAXIMUM_NUMBER.getValue() + 1
        );
    }
}
