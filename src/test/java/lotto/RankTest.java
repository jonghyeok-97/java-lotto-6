package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @DisplayName("번호가 6개 일치하면 1등이다.")
    @ParameterizedTest
    @CsvSource(value = {
            "6,true,FIRST",
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,true,FOURTH",
            "4,false,FOURTH",
            "3,true,FIFTH",
            "3,false,FIFTH",
            "2,true,NONE",
            "1,true,NONE",

    })
    void findRank_matchingCountIs6_FIRST(int count, boolean hasBonus, Rank rank) {
        assertThat(Rank.find(count, hasBonus)).isEqualTo(rank);
    }

    @DisplayName("번호가 6개를 넘으면 예외를 발생한다")
    @Test
    void findRank_CountOver6_Error() {
        assertThatThrownBy(() -> Rank.find(7, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 6개를 넘으면 NONE 발생한다")
    @Test
    void findRank_CountOver6_Erro2r() {
        assertThat(Rank.find(7, true)).isEqualTo(Rank.NONE);
    }
}
