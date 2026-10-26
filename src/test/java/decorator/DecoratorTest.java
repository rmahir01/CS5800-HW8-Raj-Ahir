//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {

    private String captureOutput(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(output));
            action.run();
        } finally {
            System.setOut(original);
        }
        return output.toString().trim();
    }

    @Test
    void burgerShouldHaveCorrectDescriptionAndCost() {
        FoodItem burger = new Burger();
        assertEquals("Burger", burger.getDescription());
        assertEquals(5.00, burger.getCost(), 0.001);
    }

    @Test
    void friesShouldHaveCorrectDescriptionAndCost() {
        FoodItem fries = new Fries();
        assertEquals("Fries", fries.getDescription());
        assertEquals(3.00, fries.getCost(), 0.001);
    }

    @Test
    void hotDogShouldHaveCorrectDescriptionAndCost() {
        FoodItem hotDog = new HotDog();
        assertEquals("Hot Dog", hotDog.getDescription());
        assertEquals(4.00, hotDog.getCost(), 0.001);
    }

    @Test
    void ketchupShouldAddItsCost() {
        FoodItem item = new Ketchup(new Burger());
        assertEquals("Burger, Ketchup", item.getDescription());
        assertEquals(5.50, item.getCost(), 0.001);
    }

    @Test
    void cheeseShouldAddItsCost() {
        FoodItem item = new Cheese(new Burger());
        assertEquals("Burger, Cheese", item.getDescription());
        assertEquals(6.00, item.getCost(), 0.001);
    }

    @Test
    void onionsShouldAddItsCost() {
        FoodItem item = new Onions(new Burger());
        assertEquals("Burger, Onions", item.getDescription());
        assertEquals(5.30, item.getCost(), 0.001);
    }

    @Test
    void decoratorShouldRejectNullFoodItem() {
        assertThrows(IllegalArgumentException.class,() -> new Cheese(null));
    }

    @Test
    void orderShouldCalculateTotalCost() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new Fries());
        assertEquals(8.00, order.getTotalCost(), 0.001);
    }

    @Test
    void orderShouldRejectNullItem() {
        Order order = new Order();
        assertThrows(IllegalArgumentException.class, () -> order.addItem(null));
    }

    @Test
    void orderShouldPrintItemsAndSubtotal() {
        Order order = new Order();
        order.addItem(new Burger());
        String output = captureOutput(order::printOrder);
        assertTrue(output.contains("Burger"));
        assertTrue(output.contains("Subtotal: $5.00"));
    }

    @Test
    void goldLoyaltyShouldApplyTenPercentDiscount() {
        assertEquals(90.00, LoyaltyStatus.GOLD.applyDiscount(100.00), 0.001);
    }

    @Test
    void regularLoyaltyShouldHaveNoDiscount() {
        assertEquals(0.00, LoyaltyStatus.REGULAR.getDiscountRate(), 0.001);
        assertEquals(100.00, LoyaltyStatus.REGULAR.applyDiscount(100.00), 0.001);
    }

    @Test
    void loyaltyShouldRejectNegativeTotal() {
        assertThrows(IllegalArgumentException.class, () -> LoyaltyStatus.GOLD.applyDiscount(-10.00));
    }

    @Test
    void decoratorDriverShouldRunOrderAndDiscount() {
        String output = captureOutput(() -> DecoratorDriver.main(new String[]{}));
        assertTrue(output.contains("Burger"));
        assertTrue(output.contains("Subtotal: $15.10"));
        assertTrue(output.contains("Final total: $13.59"));
    }
}

