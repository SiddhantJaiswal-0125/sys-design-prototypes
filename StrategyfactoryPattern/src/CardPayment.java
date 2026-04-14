public class CardPayment implements  PaymentStrategy{
    private String cardNumber;
    public CardPayment(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }
    public void pay(double amount)
    {
        System.out.println("Card Payment Done - "+amount+" with Card Number "+ cardNumber);
    }
}
