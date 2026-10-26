//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public class DecoratorDriver {

    public static void main(String[] args) {

        FoodItem burger = new Cheese(new Ketchup(new Burger()));
        FoodItem fries = new Onions(new Fries());
        FoodItem hotDog = new Cheese(new Onions(new HotDog()));

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(hotDog);

        System.out.println("=== RESTAURANT ORDER ===");
        order.printOrder();

        LoyaltyStatus loyalty = LoyaltyStatus.GOLD;

        double subtotal = order.getTotalCost();
        double finalTotal = loyalty.applyDiscount(subtotal);
        double savings = subtotal - finalTotal;

        System.out.println("\n=== LOYALTY DISCOUNT ===");
        System.out.println("Loyalty status: " + loyalty);
        System.out.printf("Discount: %.0f%%%n", loyalty.getDiscountRate() * 100);
        System.out.printf("Savings: $%.2f%n", savings);
        System.out.printf("Final total: $%.2f%n", finalTotal);
    }
}
