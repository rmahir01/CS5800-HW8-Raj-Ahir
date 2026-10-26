//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public class Fries implements FoodItem {

    @Override
    public String getDescription() {
        return "Fries";
    }

    @Override
    public double getCost() {
        return 3.00;
    }
}