package consumers;

import java.util.Scanner;

public class ConsumerExample {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runningBookstore();
    }

    private static void runningBookstore() {
        System.out.println("Welcome to the Java Bookstore!");
        chooseAction();
    }

    private static void chooseAction() {
        Order order = new Order();
        String action;

        do {
            System.out.println("Choose an action: [add] item, [checkout], or [quit]");
            action = scanner.nextLine();
            switch (action.toLowerCase()) {
                case "add":
                    addItem(order);
                    break;

                case "checkout":
                    checkout(order);
                    break;

                case "quit":
                    System.out.println("Thank you for visiting the Java Bookstore !");
                    break;

                default:
                    System.out.println("Invalid action. Please try again.");
            }
        } while (!action.equalsIgnoreCase("quit"));
    }

    private static void checkout(Order order) {
        CheckoutService checkoutService = new CheckoutService();
        System.out.println("Enter any discount amount, if applicable:");
        double discount = Double.parseDouble(scanner.nextLine());
        int number = 0;
        checkoutService.checkout(order, new Coupon(discount, ++number));
        order = new Order(); // Reset the order for next customer
    }

    private static void addItem(Order order) {
        System.out.println("Enter the name of the book:");
        String name = scanner.nextLine();
        System.out.println("Enter the price of the book:");
        double price = priceInput();
        order.addItem(new Item(name, price));
        System.out.println("Item added to order.");
    }

    private static double priceInput() {
        double price = 0.0;
        boolean enterRightInput = false;
        while (!enterRightInput) {
            try {
                price = scanner.nextDouble();
                enterRightInput = true;
            } catch (Exception ex) {
                System.out.println("Please enter number!");
            } finally {
              scanner.nextLine();
            }
        }
        return price;
    }
}
