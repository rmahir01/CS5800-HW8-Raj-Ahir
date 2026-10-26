//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

public abstract class PaymentNotification {

    protected final NotificationChannel channel;

    protected PaymentNotification(NotificationChannel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("Notification channel cannot be null");
        }
        this.channel = channel;
    }

    public abstract void notifyPayment(double amount);
}
