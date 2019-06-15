package singleton;

public class SingletonEnum {

    public enum EasySingleton {
        INSTANCE;

        public void doSome() {
            System.out.println("ha");
        }
    }

    public static void main(String[] args) {
        EasySingleton.INSTANCE.doSome();
    }

}