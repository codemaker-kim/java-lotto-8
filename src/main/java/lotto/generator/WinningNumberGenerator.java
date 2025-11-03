package lotto.generator;

import java.util.List;
import lotto.domain.WinningNumber;

public class WinningNumberGenerator {

    public WinningNumber generateWinningNumber(List<Integer> numbers) {
        return new WinningNumber(numbers);
    }
}
