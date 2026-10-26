//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

public class OnlinePaymentNotification
        extends PaymentNotification {

    private final String paymentMethod;

    public OnlinePaymentNotification(
            NotificationChannel channel,
            String paymentMethod) {

        super(channel);

        if (paymentMethod == null
                || !(paymentMethod.equalsIgnoreCase("Credit Card")
                || paymentMethod.equalsIgnoreCase("PayPal"))) {
            throw new IllegalArgumentException("Payment method must be Credit Card or PayPal");
        }
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void notifyPayment(double amount) {
        channel.send("Online payment of $" + String.format("%.2f", amount)
                        + " received through " + paymentMethod + ".");
    }
}