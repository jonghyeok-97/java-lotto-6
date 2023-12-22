package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoGroup;
import lotto.domain.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoFactoryTest {

    @DisplayName("구입금액의 1000을 나눈 값만큼 로또가 발행된다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5000,5", "10000,10"})
    void createLottoCount(int value, int lottoCount) {
        Price price = Price.from(value);
        List<Lotto> lottos = LottoFactory.createLottos(price);

        Assertions.assertThat(lottos.size()).isEqualTo(lottoCount);
    }

//    @DisplayName("구입금액의 1000을 나눈 값만큼 로또가 발행된다.")
//    @ParameterizedTest
//    @CsvSource(value = {"1000,1", "5000,5", "10000,10"})
//    void createLotto_byPrice_LottoCount(int lottoPurchasePrice, int lottoCount) {
//        LottoGroup lottoGroup = LottoGroup.from(Price.from(lottoPurchasePrice));
//
//        Assertions.assertThat(lottoGroup.getLottos().size()).isEqualTo(lottoCount);
//    }

}
