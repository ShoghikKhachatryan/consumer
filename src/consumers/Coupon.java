package consumers;

public class Coupon {

    private final double discount;

    private final int number;

    public Coupon(double discount, int number) {
        this.number = number;
        this.discount = discount / 100;
    }

    public double discount() {
        return discount ;
    }

    public int number() {
        return number;
    }
}
