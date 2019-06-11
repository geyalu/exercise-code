package singleton;

public class SingletonEnum {

    public enum EasySingleton{
        INSTANCE;

        public void doSome(){
            System.out.println("hah");
        }
    }

    public static void main(String[] args) {
        EasySingleton.INSTANCE.doSome();
    }

}
