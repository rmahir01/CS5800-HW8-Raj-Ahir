//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public class Burger implements FoodItem {

    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}
