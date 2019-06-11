package sort;

public class QuickSort {

    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];


        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }



            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                i++;
            }
        }

        System.out.println("qsort head="+head+" i="+i+" j="+j);
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    public static void testQSort(int[] arr, int head, int tail) {
        if (arr == null || arr.length <= 1 || head >= tail) {
            return;
        }

        int i = head;
        int j = tail;
        int pivot = arr[(head + tail) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }


        testQSort(arr, head, i);
        testQSort(arr, j, tail);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 3, 4};
        qSort(arr, 0, arr.length - 1);


        String out = "";

        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
