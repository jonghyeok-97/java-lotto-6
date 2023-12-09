package lotto.domain;

public class Price {
    private final int price;

    private Price(int price) {
        validate(price);
        this.price = price;
    }

    public static Price from(int price) {
        return new Price(price);
    }

    public int divideByPricePerOneLotto() {
        return price / 1000;
    }

    private void validate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 가격은 1000원 단위어야 합니다.");
        }
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 1000원은 입력하세요.");
        }
        if (price > 2000000000) {
            throw new IllegalArgumentException("[ERROR] 최대 구입 금액은 20억입니다.");
        }
    }
}
