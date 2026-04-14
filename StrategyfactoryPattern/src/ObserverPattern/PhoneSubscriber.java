package ObserverPattern;

public class PhoneSubscriber implements Observer {
    String phoneNumber;
    PhoneSubscriber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String message)
    {
        System.out.println("Notfied User via Phone Number: "+phoneNumber+" message "+message);

    }

}
