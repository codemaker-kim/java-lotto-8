package lotto.domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    public WinningNumber (List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        int numbersSize = numbers.size();

        if (numbersSize != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }

        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != numbersSize) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 중복되는 숫자가 존재합니다.");
        }
    }
}
