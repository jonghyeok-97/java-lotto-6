package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoDto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoGroup;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Price;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
//        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator(createPrice());
//        randomLottoGenerator.createRandomLottos();
        Price price = createPrice();
        LottoGroup lottoGroup = LottoGroup.from(LottoFactory.createLottos(price));
        OutputView.printLottos(LottoDto.from(lottoGroup));

        WinningLotto winningLotto = createWinningLotto();
        Result result = lottoGroup.calculate(winningLotto);
        OutputView.printStatics(lottoGroup.calculate(winningLotto));
        OutputView.printProfit(price.calculateProfit(result));
    }

    private Price createPrice() {
        try {
            return Price.from(InputView.readPrice());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return createPrice();
        }
    }

    private WinningLotto createWinningLotto() {
        try {
            Lotto winningLotto = Lotto.from(LottoFactory.createLotto(InputView.readWinningNumbers()));
            LottoNumber bonusNumber = LottoNumber.from(InputView.readBonus());
            return WinningLotto.of(winningLotto, bonusNumber);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return createWinningLotto();
        }
    }
}
