package PRJAVA.singleton.holder;

import PRJAVA.singleton.lazyinit.Singleton;

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



