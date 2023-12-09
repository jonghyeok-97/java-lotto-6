package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("로또번호가 1~45사이면 예외가 발생하지 않는다.")
    @Test
    void validRange_doesNotThrowAnyException() {
        assertThatCode(() -> IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::from))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또번호가 1~45사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47, 100})
    void invalidRange_ThrowException(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1~45숫자 여야 합니다.");
    }
}
