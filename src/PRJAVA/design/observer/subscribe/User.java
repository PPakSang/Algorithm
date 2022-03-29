package PRJAVA.design.observer.subscribe;

public class User implements Subscriber{
    private String name;

    User(String name) {
        this.name = name;
    }

    @Override
    public void update(String notice) {
        System.out.println("-"+this.name);
        System.out.println("=====Receive Notice=====");
        System.out.println(notice);
        System.out.println();
    }
}
