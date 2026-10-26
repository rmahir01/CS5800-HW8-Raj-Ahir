//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

public class BitcoinPayment extends PaymentNotification {

    public BitcoinPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyPayment(double amount) {
        channel.send("Bitcoin payment of $" + String.format("%.2f", amount)
                        + " received and confirmed.");
    }
}
