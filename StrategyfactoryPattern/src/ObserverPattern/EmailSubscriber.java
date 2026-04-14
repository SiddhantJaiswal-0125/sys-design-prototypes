package ObserverPattern;

public class EmailSubscriber implements  Observer{
    String email;
    EmailSubscriber(String email)
    {
        this.email = email;
    }

    @Override
    public void notify(String message)
    {
        System.out.println("Notfied User via Email: "+email+" message "+message);

    }

}
