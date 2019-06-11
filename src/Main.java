import singleton.SingletonEnum;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SingletonEnum.EasySingleton.INSTANCE.doSome();
    }
}
