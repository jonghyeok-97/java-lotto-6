package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    public int readPrice() {
        String input = Console.readLine();
        validateNumber(input);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
