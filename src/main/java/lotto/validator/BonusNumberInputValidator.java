package lotto.validator;

public class BonusNumberInputValidator {
    public void validate(String input) {
        validateEmpty(input);

        validateInteger(input);
    }

    private void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력이 비어있습니다.");
        }
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력에는 숫자만 입력 가능합니다.");
        }
    }
}
