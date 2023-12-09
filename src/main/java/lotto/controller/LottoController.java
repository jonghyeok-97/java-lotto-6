package lotto.controller;

import lotto.domain.LottoFactory;
import lotto.domain.LottoGroup;
import lotto.domain.Price;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Price price = Price.from(inputView.readPrice());
        LottoGroup lottoGroup = LottoGroup.from(LottoFactory.createLottoGroup(price));

    }
}
