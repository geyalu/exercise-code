package singleton;

public class SingletonDCL {
    private volatile static SingletonDCL instance; //声明成 volatile

    private SingletonDCL() {
    }

    public static SingletonDCL getSingleton() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
