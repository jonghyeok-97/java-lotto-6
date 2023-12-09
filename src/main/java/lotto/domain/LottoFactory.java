package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static List<Lotto> createLottoGroup(Price price) {
        int lottoCount = price.divideByPricePerOneLotto();
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .map(Lotto::from)
                .collect(Collectors.toList());
        return lottos;
    }
}
