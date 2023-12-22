package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

//    @DisplayName("당첨번호가 보너스 번호를 포함하면 당첨번호는 생성이 안된다.")
//    @ParameterizedTest
//    @ValueSource(ints = {1,2,3,4,5,6})
//    void validateWinningLotto_ContainBonus_Error(int number) {
//        Lotto winningLotto = Lotto.fromRaw(List.of(1, 2, 3, 4, 5, 6));
//        LottoNumber bonusNumber = LottoNumber.from(number);
//
//        Assertions.assertThatThrownBy(() -> WinningLotto.of(winningLotto, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}
