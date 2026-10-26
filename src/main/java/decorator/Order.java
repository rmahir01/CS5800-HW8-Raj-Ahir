//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Order item cannot be null");
        }
        items.add(item);
    }

    public double getTotalCost() {
        double total = 0.0;
        for (FoodItem item : items) {
            total += item.getCost();
        }
        return total;
    }

    public void printOrder() {
        for (FoodItem item : items) {
            System.out.printf(
                    "%s - $%.2f%n",
                    item.getDescription(),
                    item.getCost()
            );
        }
        System.out.printf("Subtotal: $%.2f%n", getTotalCost());
    }
}
