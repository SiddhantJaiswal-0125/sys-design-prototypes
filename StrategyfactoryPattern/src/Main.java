public class Main {
    public static void main(String[] args) {

            System.out.println("Hello world!");

            PaymentFactory factory;
            factory = new UPIFactory();
            PaymentService upiService = new PaymentService(factory);
            upiService.processPayment(120);

            factory = new CardFactory();
            PaymentService cardService = new PaymentService(factory);
            cardService.processPayment(150);


    }
}