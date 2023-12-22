package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PriceTest {

    @DisplayName("구입금액이 천원 단위가 아니면 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 500, 1500, 2001, 2010})
    void createPriceByPurchaseUnit1(int price) {
        assertThatThrownBy(() -> Price.from(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 가격은 1000원 단위어야 합니다.");
    }

    @DisplayName("구입금액이 천원 단위면 통과한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000})
    void createPriceByPurchaseUnit2(int price) {
        assertThatCode(() -> Price.from(price))
                .doesNotThrowAnyException();
    }

    @DisplayName("구입금액이 천원 단위어도 천원이 넘지 않으면 예외 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    void createPriceByMinPrice1(int price) {
        assertThatThrownBy(() -> Price.from(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 천원 단위이고, 1000원~20억 사이면 통과한다")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000000000})
    void createPriceByMinPrice2(int price) {
        assertThatCode(() -> Price.from(price))
                .doesNotThrowAnyException();
    }

    @DisplayName("구입금액이 천원 단위어도 20억을 넘으면 예외 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {2000001000})
    void createPriceByMaxPrice1(int price) {
        assertThatThrownBy(() -> Price.from(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값이_같으면_동일하다() {
        Price price1 = Price.from(10000);
        Price price2 = Price.from(10000);

        assertThat(price1==price2).isTrue();
    }
}
