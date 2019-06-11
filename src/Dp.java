public class Dp {

    public static int[] values = {10, 40, 30, 50};
    public static int[] weights ={5, 4, 6, 3};

    public static void main(String[] args) {
        int cap =10;

        int calue = maxValue(3,cap);
        System.out.println(calue);

    }


    public static int maxValue(int pos, int cap) {
        if (cap<=0){
            return 0;
        }

        if (pos == 0) {
            if (weights[pos] <= cap) {
                return values[pos];
            } else {
                return 0;
            }
        }else {
            int choosed = values[pos]+maxValue(pos-1,cap-weights[pos]);
            int notchoose = maxValue(pos-1,cap);

            System.out.println("choosed:"+choosed+" notchoose:"+notchoose);
           return max(choosed,notchoose);

        }


    }


    public static int max(int a,int b){
        if (a>b){
            return a;
        } else  {
            return b;
        }
    }

}
