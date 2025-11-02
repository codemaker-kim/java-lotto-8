package lotto.validator;

public class WinningNumberInputValidator {

    public void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 입력이 비어있습니다.");
        }
    }
}
