package PRJAVA.design.singleton.holder;

public class SingletonHolder {

    private SingletonHolder() {}

    public static SingletonHolder getInstance() {
        return Holder.instance;
    }

    //inner class
    private static class Holder {
        public static final SingletonHolder instance = new SingletonHolder();
    }
}



