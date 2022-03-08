package PRJAVA.singleton.eagerinit;

public class SingletonEager {

    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {}

    public static SingletonEager getInstance() {

        return instance;
    }
}

