package sort;

public class InsertionSort {

    public static void insertionSort(int[] arr){
        for (int i=1; i<arr.length; ++i){
            int value = arr[i];
            int position=i;
            while (position>0 && arr[position-1]>value){
                arr[position] = arr[position-1];
                position--;
            }
            arr[position] = value;
        }//loop i
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 3, 4};
        insertionSort(arr);

        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
