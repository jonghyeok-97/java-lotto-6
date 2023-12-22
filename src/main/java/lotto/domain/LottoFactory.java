package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static List<LottoNumber> createLotto(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

//    public static LottoGroup createLottos(List<List<Integer>> randomLottos) {
//
//        return LottoGroup.from(randomLottos.stream()
//                .map(LottoFactory::createLotto)
//                .map(Lotto::from)
//                .collect(Collectors.toList()));
//    }

    public static List<Lotto> createLottos(Price price) {
        int count = price.drawHowManyLotto();

        return IntStream.range(0, count)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .map(LottoFactory::createLotto)
                .map(Lotto::from)
                .collect(Collectors.toList());
    }
}
