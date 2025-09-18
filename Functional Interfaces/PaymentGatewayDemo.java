interface PaymentProcessor {
    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Refunded " + amount);
    }
}

class PayPal implements PaymentProcessor {
    public void processPayment(double amount) { System.out.println("Processed " + amount + " via PayPal"); }
}

public class PaymentGatewayDemo {
    public static void main(String[] args) {
        PaymentProcessor pp = new PayPal();
        pp.processPayment(500);
        pp.refund(200);
    }
}
