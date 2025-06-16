package dip;

import dip.payment.CreditCardPayment;
import dip.payment.CryptoPayment;
import dip.payment.PayPalPayment;
import dip.payment.PaymentProcessor;
import dip.payment.PaymentMethod;

public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod paypal = new PayPalPayment();
        PaymentMethod crypto = new CryptoPayment();

        PaymentProcessor processor1 = new PaymentProcessor(creditCard);
        processor1.makePayment(150.0);

        PaymentProcessor processor2 = new PaymentProcessor(paypal);
        processor2.makePayment(200.0);

        PaymentProcessor processor3 = new PaymentProcessor(crypto);
        processor3.makePayment(300.0);
    }
}
