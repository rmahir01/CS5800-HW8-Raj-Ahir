//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

public class PushChannel implements NotificationChannel {

    @Override
    public void send(String message) {
        System.out.println("[PUSH] " + message);
    }
}
