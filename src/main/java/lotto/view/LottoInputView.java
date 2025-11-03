package lotto.view;

import static lotto.view.InputViewMessage.BONUS_NUMBER_INPUT;
import static lotto.view.InputViewMessage.MONEY_INPUT;
import static lotto.view.InputViewMessage.WINNING_NUMBER_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    public static String getMoneyInput() {
        System.out.println(
                MONEY_INPUT.getMessage());

        return Console.readLine();
    }

    public static String getWinningNumberInput() {
        System.out.println(
                WINNING_NUMBER_INPUT.getMessage());

        return Console.readLine();
    }

    public static String getBonusNumberInput() {
        System.out.println(
                BONUS_NUMBER_INPUT.getMessage());

        return Console.readLine();
    }
}
