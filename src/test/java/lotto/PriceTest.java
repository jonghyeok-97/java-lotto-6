package lotto;

import lotto.domain.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PriceTest {

    @DisplayName("구입금액이 천원 단위가 아니면 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2001, 2010})
    void createPriceByPurchaseUnit(int price) {
        Assertions.assertThatThrownBy(() -> Price.from(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 가격은 1000원 단위어야 합니다.");
    }
}
