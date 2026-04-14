public class UPIFactory extends PaymentFactory{

    @Override
    public PaymentStrategy createStrategy()
    {
        return new UPIPayment("test@abc.bank");
    }
}
