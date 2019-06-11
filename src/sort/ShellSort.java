package sort;

public class ShellSort {
    public static void shellSort(int[] array) {
        int len;
        len = array.length / 2; // 分成n/2组

        while (len >= 1) {
            for (int i = len; i < array.length; ++i) { //对每组进行直接插入排序
                int temp = array[i];
                int j = i - len;
                while (j >= 0 && array[j] > temp) {
                    array[j + len] = array[j];
                    j -= len;
                }
                array[j + len] = temp;
            }

            len /= 2;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 3, 4};
        shellSort(arr);

        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }

}
