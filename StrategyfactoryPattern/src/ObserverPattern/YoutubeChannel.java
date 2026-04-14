package ObserverPattern;

import java.util.ArrayList;

public class YoutubeChannel implements Subject{
    String latestVideo;
    ArrayList<Observer> list;

    YoutubeChannel()
    {
        list = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer obs) {
        list.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        list.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : list) {
            ob.notify(latestVideo);
        }
    }
    public void uploadVideo(String video)
    {
        this.latestVideo = video;
        System.out.println("New Video Uploaded "+video);
        notifyObservers();
    }

}
