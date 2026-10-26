//CS5800 - HW8 - BRIDGE
//RAJ AHIR - 019330454

package bridge;

public class BridgeDriver {

    public static void main(String[] args) {

        NotificationChannel email = new EmailChannel();
        NotificationChannel sms = new SmsChannel();
        NotificationChannel push = new PushChannel();

        System.out.println("=== ONLINE PAYMENT ===");

        PaymentNotification onlineEmail = new OnlinePaymentNotification(email, "Credit Card");
        onlineEmail.notifyPayment(109.00);

        PaymentNotification onlineSms = new OnlinePaymentNotification(sms, "PayPal");
        onlineSms.notifyPayment(58.50);

        System.out.println("\n=== CASH ON DELIVERY ===");

        PaymentNotification cashEmail = new CashOnDeliveryPayment(email);
        cashEmail.notifyPayment(41.80);

        PaymentNotification cashSms = new CashOnDeliveryPayment(sms);
        cashSms.notifyPayment(63.25);

        System.out.println("\n=== BITCOIN PAYMENT ===");

        PaymentNotification bitcoinEmail = new BitcoinPayment(email);
        bitcoinEmail.notifyPayment(145.08);

        PaymentNotification bitcoinSms = new BitcoinPayment(sms);
        bitcoinSms.notifyPayment(65.09);

        System.out.println("\n=== PUSH NOTIFICATIONS ===");

        PaymentNotification onlinePush = new OnlinePaymentNotification(push, "PayPal");
        onlinePush.notifyPayment(209.80);

        PaymentNotification cashPush = new CashOnDeliveryPayment(push);
        cashPush.notifyPayment(59.99);
    }
}
