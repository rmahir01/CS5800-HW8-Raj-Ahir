//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    private String captureOutput(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(output));
            action.run();
        } finally {
            System.setOut(original);
        }
        return output.toString().trim();
    }

    @Test
    void emailChannelShouldSendMessage() {
        String output = captureOutput(() -> new EmailChannel().send("Test message"));
        assertEquals("[EMAIL] Test message", output);
    }

    @Test
    void smsChannelShouldSendMessage() {
        String output = captureOutput(() -> new SmsChannel().send("Test message"));
        assertEquals("[SMS] Test message", output);
    }

    @Test
    void pushChannelShouldSendMessage() {
        String output = captureOutput(() -> new PushChannel().send("Test message"));
        assertEquals("[PUSH] Test message", output);
    }

    @Test
    void onlinePaymentShouldNotifyThroughEmail() {
        String output = captureOutput(() -> new OnlinePaymentNotification(new EmailChannel(),
                "Credit Card").notifyPayment(100.00));
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("$100.00"));
        assertTrue(output.contains("Credit Card"));
    }

    @Test
    void cashOnDeliveryShouldNotifyThroughSms() {
        String output = captureOutput(() ->
                new CashOnDeliveryPayment(new SmsChannel()).notifyPayment(45.00));
        assertTrue(output.contains("[SMS]"));
        assertTrue(output.contains("$45.00"));
        assertTrue(output.contains("collected on delivery"));
    }

    @Test
    void bitcoinShouldNotifyThroughEmail() {
        String output = captureOutput(() ->
                new BitcoinPayment(new EmailChannel()).notifyPayment(120.00));
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("$120.00"));
        assertTrue(output.contains("Bitcoin"));
    }

    @Test
    void onlinePaymentShouldRejectUnsupportedMethod() {
        assertThrows(IllegalArgumentException.class,
                () -> new OnlinePaymentNotification(new EmailChannel(), "Cash"));
    }

    @Test
    void paymentShouldRejectNullChannel() {
        assertThrows(IllegalArgumentException.class,
                () -> new CashOnDeliveryPayment(null));
    }

    @Test
    void bridgeDriverShouldRunAllScenarios() {
        String output = captureOutput(() -> BridgeDriver.main(new String[]{}));
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("[SMS]"));
        assertTrue(output.contains("[PUSH]"));
        assertTrue(output.contains("Bitcoin"));
    }
}
