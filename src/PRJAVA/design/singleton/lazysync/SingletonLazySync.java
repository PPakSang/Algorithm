package PRJAVA.design.singleton.lazysync;

import java.util.Objects;

public class SingletonLazySync {

    private static SingletonLazySync instance;

    private SingletonLazySync() {}

    public static SingletonLazySync getInstance() {

        if (instance == null) {

            synchronized (SingletonLazySync.class) {
                if (Objects.isNull(instance)) {

                    return instance = new SingletonLazySync();
                }
            }
        }
        return instance;
    }
}

