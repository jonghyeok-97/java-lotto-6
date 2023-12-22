package lotto;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
//    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
//    @Test
//    void createLottoByOverSize() {
//        List<LottoNumber> lotto = LottoFactory.createLotto(List.of(1, 2, 3, 4, 5, 6,7));
//        assertThatThrownBy(() -> Lotto.from(lotto))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void createLottoByDuplicatedNumber() {
//        assertThatThrownBy(() -> Lotto.from(LottoFactory.createLotto(List.of(1, 2, 3, 4, 5, 5))))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
//    @Test
//    void sorted() {
//        Lotto actualLotto = Lotto.fromRaw(Arrays.asList(1,3,9,14,15,11));
//        Lotto expectedLotto = Lotto.fromRaw(Arrays.asList(1, 3, 9, 11, 14, 15));
//
//        assertThat(actualLotto).isEqualTo(expectedLotto);
//    }
//
//    @DisplayName("로또가 번호를 포함여부를 안다.")
//    @ParameterizedTest
//    @ValueSource(ints = {1,3,9,14,15})
//    void isContain_containsLottoNumber_True(int number) {
//        Lotto lotto = Lotto.fromRaw(Arrays.asList(1,3,9,14,15,11));
//        LottoNumber lottoNumber = LottoNumber.from(number);
//
//        assertThat(lotto.isContain(lottoNumber)).isTrue();
//    }
}