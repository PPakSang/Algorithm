package PRJAVA.design.observer.basic;

public class Child implements Listener{
    private String state;

    public String getState() {
        return state;
    }

    @Override
    public void update(Parent parent) {
        System.out.println("Parent State is Change From " +
                parent.getPreState() +
                " To " +
                parent.getState());
    }
}
