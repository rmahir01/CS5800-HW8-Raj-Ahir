//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

public class CashOnDeliveryPayment
        extends PaymentNotification {

    public CashOnDeliveryPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyPayment(double amount) {
        channel.send("Order total: $" + String.format("%.2f", amount)
                        + ". Payment will be collected on delivery.");
    }
}