package PRJAVA.design.observer.basic;

public class Main {

    public static void main(String[] args) {
        Parent parent = new Parent();

        Listener child1 = new Child();
        Listener child2 = new Child();

        parent.addListener(child1);
        parent.addListener(child2);

        parent.setState("Hot");
        parent.setState("Cool");
    }
}
