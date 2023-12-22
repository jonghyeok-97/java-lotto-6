package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoNumber;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("로또번호가 1~45사이면 예외가 발생하지 않는다.")
    @Test
    void createLottoNumberByValidRange() {
        assertThatCode(() -> IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::from))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또번호가 1~45사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47, 100})
    void createLottoNumberByInvalidRange(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1~45숫자 여야 합니다.");
    }

//    @DisplayName("발행된 로또들 마다 당첨 등수를 계산한다.")
//    @Test
//    void calculateWinningRanks_Lottos_Rank() {
//        List<Lotto> lottos = Arrays.asList(
//                Lotto.fromRaw(Arrays.asList(1,2,3,4,5,6)),
//                Lotto.fromRaw(Arrays.asList(1,2,3,4,5,7)),
//                Lotto.fromRaw(Arrays.asList(10,12,13,14,15,17))
//        );
//
//        WinningLotto winningLotto = WinningLotto.of(Lotto.fromRaw(Arrays.asList(1,2,3,4,5,6)), LottoNumber.from(7));
//        LottoGroup lottoGroup = LottoGroup.from(lottos);
//        Result result = lottoGroup.calculate(winningLotto);
//
//        List<Integer> values = new ArrayList<>(result.getRanks().values());
//        Assertions.assertThat(values).isEqualTo(List.of(1, 1, 0, 0, 0, 1));
//    }
}
