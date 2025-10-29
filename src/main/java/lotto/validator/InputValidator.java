package lotto.validator;

public class InputValidator {
    public void validate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액 입력이 비어있습니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액 입력에는 숫자만 입력 가능합니다.");
        }
    }
}
