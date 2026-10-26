//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public class Ketchup extends FoodDecorator {

    public Ketchup(FoodItem item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", Ketchup";
    }

    @Override
    public double getCost() {
        return item.getCost() + 0.50;
    }
}