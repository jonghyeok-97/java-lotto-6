package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomLottoGenerator {
    private final Price price;

    public RandomLottoGenerator(Price price) {
        this.price = price;
    }

    public List<List<Integer>> createRandomLottos() {
        int lottosCount = price.drawHowManyLotto();
        List<List<Integer>> randomLottos = new ArrayList<>();

        for (int i = 0; i < lottosCount; i++) {
            randomLottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return randomLottos;
    }
}
