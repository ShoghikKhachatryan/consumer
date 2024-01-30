package consumers;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CheckoutService {

    private final Consumer<Order> processOrder = order -> System.out.println("Order processed. Total: $" +
            String.format("%.2f", order.totalPrice())
    );

    private final BiConsumer<Order, Coupon> applyDiscount = (order, coupon) -> {
        order.applyDiscount(coupon);
        System.out.println("Discount of $" + (order.totalPrice() * coupon.discount()) + " applied. New total: $" + String.format("%.2f", order.totalPrice()));
    };


    public void checkout(Order order, Coupon coupon) {
        if (coupon.discount() > 0) {
            applyDiscount.accept(order, coupon);
        }

        processOrder.accept(order);
    }
}
