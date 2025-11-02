package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyInputValidatorTest {

    private MoneyInputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new MoneyInputValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("로또 구입금액 입력이 비어있을 경우, 예외를 발생시킨다.")
    void emptyMoneyInput(String input) {
        // assert
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입금액 입력이 비어있습니다.");
    }

    @ParameterizedTest
    @DisplayName("로또 구입금액 입력이 숫자가 아닐 경우, 예외를 발생시킨다.")
    @ValueSource(strings = {
            ",,,,",
            "abasdf",
            "!@#$%",
            "132,45",
            "12,345"
    })
    void notNumericMoneyInput(String invalidInput) {
        // given
        final String input = invalidInput;

        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입금액 입력에는 숫자만 입력 가능합니다.");
    }
}
