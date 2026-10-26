//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public class HotDog implements FoodItem {

    @Override
    public String getDescription() {
        return "Hot Dog";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}