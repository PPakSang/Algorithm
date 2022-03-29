package PRJAVA.design.observer.subscribe;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Youtuber{
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void notify2Subscriber(String notice) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(notice);
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}
