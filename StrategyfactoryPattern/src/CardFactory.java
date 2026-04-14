public class CardFactory extends PaymentFactory{

    @Override
    public PaymentStrategy createStrategy()
    {
        return new CardPayment("1234-7890-5678");
    }
}

