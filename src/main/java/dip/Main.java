package dip;

import dip.payment.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.makePayment(150.0);
    }
}
