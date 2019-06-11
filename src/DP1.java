public class DP1 {

    public static void main(String[] args) {
        int maxW = 10;
        int number = 4;
        int w[] = {5, 4, 6, 3};
        int v[] = {10, 40, 30, 50};
        int[][] b = backPackSolution(maxW, number, w, v);
        for (int i = 0; i <= number; i++) {
            for (int j = 0; j <= maxW; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] backPackSolution(int maxW, int number, int[] w, int[] v) {
//      没有空间或者商品数是0的时候多出1
        int b[][] = new int[number + 1][maxW + 1];
//      相当于遍历商品
        for (int i = 1; i < number + 1; i++) {
//          j代表剩余的空间
            for (int j = 1; j < maxW + 1; j++) {
//              这件商品和剩余空间进行比较
                if (w[i - 1] < j) {
//                    小于表示可以偷，现在决定怎么偷
                    if (b[i - 1][j] < (b[i - 1][j - w[i - 1]] + v[i - 1])) {
                        b[i][j] = b[i - 1][j - w[i - 1]] + v[i - 1];
                    } else {
                        b[i][j] = b[i - 1][j];
                    }
                } else {
//                  不偷了
                    b[i][j] = b[i - 1][j];
                }
            }
        }
        return b;
    }
}
