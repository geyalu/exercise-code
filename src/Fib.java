import java.util.HashMap;

public class Fib {

    public static HashMap fibMap = new HashMap();

    public static int fibna(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 2 || n == 1) {
            return 1;
        }

        if (fibMap.containsKey(n)){
            return (int) fibMap.get(n);
        }

        int rt = fibna(n - 2) + fibna(n - 1);

        fibMap.put(n,rt);

        return rt;

    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fibna(40));

        System.out.println(System.currentTimeMillis() - start);
    }
}
