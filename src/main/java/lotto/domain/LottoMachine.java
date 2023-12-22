package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor.STRING;

public class LottoMachine {
    private final int lottoCount;

    public LottoMachine(Price price) {
        int lottoCount = price.drawHowManyLotto();
        this.lottoCount = lottoCount;
    }

    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }


}
