public class array {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int[] result = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                i++;
                k++;
            } else {
                result[k] = nums2[j];
                j++;
                k++;
            }
        }


        while (j < n) {
            result[k] = nums2[j];
            k++;
            j++;
        }

        while (i < m) {
            result[k] = nums1[i];
            k++;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] c = merge(new int[]{1, 2, 3, 4}, 4, new int[]{0, 2, 4, 5, 6, 7, 8}, 7);
        for (int i = 0; i < c.length; i++)
            System.out.println(c[i]);
    }


}
