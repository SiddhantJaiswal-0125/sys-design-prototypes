public class PaymentService {
    public PaymentStrategy strategy;

    public PaymentService(PaymentFactory paymentFactory)
    {
        this.strategy = paymentFactory.createStrategy();
    }

    public void processPayment(double amount)
    {
        strategy.pay(amount);
    }
}
