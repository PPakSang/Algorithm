package PRJAVA.design.observer.basic;

import java.util.*;

public class Parent {
    List<Listener> listeners = new ArrayList<>();

    private String preState;
    private String state;

    Parent() {
        this.state = "null";
    }

    public void setState(String state) {
        preState = this.state;
        this.state = state;
        notify2Child();
    }

    public String getPreState() {
        return preState;
    }

    public String getState() {
        return state;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    private void notify2Child() {
        for (Listener listener : listeners) {
            listener.update(this);
        }
    }
}
