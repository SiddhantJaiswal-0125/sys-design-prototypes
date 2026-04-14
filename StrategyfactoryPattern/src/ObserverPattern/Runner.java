package ObserverPattern;

public class Runner {
    public static void main(String[] args) {
        YoutubeChannel yt = new YoutubeChannel();

        Observer ob1 = new PhoneSubscriber("1234");
        Observer ob2 = new EmailSubscriber("abc@xyz.com");
        yt.addObserver(ob1);
        yt.addObserver(ob2);
        yt.uploadVideo("Strategy Pattern Uploaded");
        yt.removeObserver(ob2);
        yt.uploadVideo("Observer Pattern Uploaded");
    }
}
