package christmas;

public enum EventPrice {
    CHAMPAGNE_SERVICE(120000),
    D_DAY_DISCOUNT(100),
    D_DAY_BASIC_DISCOUNT(1000),
    DAY_DISCOUNT(2023);

    private final int price;

    EventPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
