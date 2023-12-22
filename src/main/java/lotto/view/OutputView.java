package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.LottoDto;
import lotto.domain.Rank;
import lotto.domain.Result;

public final class OutputView {

    public static void printLottos(LottoDto lottodto) {
        List<List<Integer>> numbersOfLottos = lottodto.getLottos();
        StringBuilder result = new StringBuilder();
        for (List<Integer> numbers : numbersOfLottos) {
            result.append(numbers)
                    .append(System.lineSeparator());
        }
        System.out.println(numbersOfLottos.size() + "개를 구매했습니다.");
        System.out.println(result);
    }

    public static void printStatics(Result result) {
        EnumMap<Rank, Integer> ranks = result.getRanks();
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n").append("---\n");
        for (Rank rank : ranks.keySet()) {
            if(rank == Rank.NONE) continue;
            sb.append(String.format("%d개 일치%s(%s원) - %d개",
                            rank.getMachingNumber(), getBonusMatchMessage(rank),
                            addCommaPerThreedigits(rank.getPrize()), ranks.get(rank)))
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
    }
    
    private static String getBonusMatchMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return ", 보너스 볼 일치 ";
        }
        return " ";
    }

    private static String addCommaPerThreedigits(int prize) {
        return String.format("%,d", prize);
    }

    public static void printProfit(float profit) {
        System.out.printf("총 수익률은 %f%입니다.", profit);
    }
}
