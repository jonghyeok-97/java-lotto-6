package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {

    public static int readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int price = toValidInt(input);
        return price;
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("1,2,3,4,5,6 와 같이 입력하세요.");
        }

    }

    public static int readBonus() {
        System.out.println("보너스 번호를 입력하세요.");
        String input = Console.readLine();
        return toValidInt(input);
    }

    private static int toValidInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다.");
        }
    }
}
