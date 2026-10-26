//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

public class EmailChannel implements NotificationChannel {

    @Override
    public void send(String message) {
        System.out.println("[EMAIL] " + message);
    }
}