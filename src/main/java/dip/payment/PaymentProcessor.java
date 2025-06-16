package dip.payment;

public class PaymentProcessor {
    private CreditCardPayment payment;

    public PaymentProcessor() {
        this.payment = new CreditCardPayment(); // Dependencia directa
    }

    public void makePayment(double amount) {
        payment.processPayment(amount);
    }
}
