package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoFactoryTest {

    @DisplayName("구입금액의 1000을 나눈 값만큼 로또가 발행된다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5000,5", "10000,10"})
    void createLottoCount(int value, int lottoCount) {
        Price price = Price.from(value);
        List<Lotto> lottos = LottoFactory.createLottoGroup(price);

        Assertions.assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}
