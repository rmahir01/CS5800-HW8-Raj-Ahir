//CS5800 - HW8 - DECORATOR
//RAJ AHIR - 019330454

package decorator;

public enum LoyaltyStatus {

    REGULAR(0.00),
    SILVER(0.05),
    GOLD(0.10),
    PLATINUM(0.15);

    private final double discountRate;

    LoyaltyStatus(double discountRate) {
        this.discountRate = discountRate;
    }

    public double applyDiscount(double total) {
        if (total < 0) {
            throw new IllegalArgumentException("Total cannot be negative");
        }
        return total * (1 - discountRate);
    }

    public double getDiscountRate() {
        return discountRate;
    }
}