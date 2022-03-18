package PRJAVA.design.singleton.lazyinit;

public class SingletonTest {

    public static void main(String[] args) {
//        Singleton _a = new Singleton(); 생성 불가능
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        System.out.println(a == b);
    }
}
