package PRJAVA.design.observer.subscribe;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Subscriber user1 = new User("User1");
        Subscriber user2 = new User("User2");

        Youtuber manager = new Manager();

        manager.addSubscriber(user1);
        manager.notify2Subscriber("Approach 1 Subscriber!");

        Thread.sleep(3000);

        manager.addSubscriber(user2);
        manager.notify2Subscriber("Approach 2 Subscriber!!");

    }
}
