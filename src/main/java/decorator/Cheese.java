//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public class Cheese extends FoodDecorator {

    public Cheese(FoodItem item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return item.getCost() + 1.00;
    }
}
