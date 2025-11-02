package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class WinningNumberInputValidatorTest {

    private WinningNumberInputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new WinningNumberInputValidator();
    }

    @ParameterizedTest
    @DisplayName("당첨번호 입력으로 빈 입력이나 null이 들어오면 예외를 발생시킨다.")
    @NullAndEmptySource
    void emptyInput(String emptyInput) {

        // assert
        assertThatThrownBy(() -> validator.validate(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호 입력이 비어있습니다.");
    }
}
