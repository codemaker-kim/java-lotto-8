package lotto.domain;

import static lotto.global.LottoConstant.MAXIMUM_NUMBER;
import static lotto.global.LottoConstant.MINIMUM_NUMBER;
import static lotto.global.LottoConstant.SIZE;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 중복되는 숫자가 존재합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOverLottoRange = numbers.stream()
                .anyMatch(number -> number < MINIMUM_NUMBER.getValue()
                        || number > MAXIMUM_NUMBER.getValue());

        if (isOverLottoRange) {
            throw new IllegalStateException("[ERROR] 당첨 번호 내의 숫자가 로또 범위를 초과합니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
