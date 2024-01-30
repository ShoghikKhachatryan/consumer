package consumers;

import java.util.ArrayList;
import java.util.List;

public class Order {

private final List<Item> items;

private  double totalPrice;

  public Order() {
    this.items = new ArrayList<>();
    this.totalPrice = 0.0;
  }

  public  void addItem(Item item){
    items.add(item);
    totalPrice += item.price();
  }

  public void applyDiscount(Coupon coupon){
    totalPrice -= coupon.discount();
  }

  public double totalPrice() {
    return totalPrice;
  }
}
