//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public abstract class FoodDecorator implements FoodItem {

    protected final FoodItem item;

    protected FoodDecorator(FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Food item cannot be null");
        }
        this.item = item;
    }
}