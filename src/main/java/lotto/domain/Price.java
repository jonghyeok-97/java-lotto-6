package lotto.domain;

public class Price {
    private final int price;

    private Price(int price) {
        validatePurchasUnit(price);
        this.price = price;
    }

    public static Price from(int price) {
        return new Price(price);
    }

    private void validatePurchasUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 가격은 1000원 단위어야 합니다.");
        }
    }
}
