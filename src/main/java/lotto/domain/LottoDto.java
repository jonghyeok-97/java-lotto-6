package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {
    private final List<List<Integer>> numbers;

    private LottoDto(List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    public static LottoDto from(LottoGroup lottoGroup) {
        return new LottoDto(lottoGroup.getLottos());
    }

    public List<List<Integer>> getLottos() {
        return this.numbers;
    }
}
