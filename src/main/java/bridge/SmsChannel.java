//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

public class SmsChannel implements NotificationChannel {

    @Override
    public void send(String message) {
        System.out.println("[SMS] " + message);
    }
}
