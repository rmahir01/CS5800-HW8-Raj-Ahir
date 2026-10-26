//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public class Onions extends FoodDecorator {

    public Onions(FoodItem item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", Onions";
    }

    @Override
    public double getCost() {
        return item.getCost() + 0.30;
    }
}