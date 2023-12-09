package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    public int readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 1000~2000000000 사이로 입력하세요.");
        }
    }
}
