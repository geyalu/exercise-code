package string;

import java.util.Arrays;

/**
 * 最长公共前缀
 */
public class StringPrefix {

    public static String MaxPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        char[] firstchar = first.toCharArray();
        char[] lastchar = last.toCharArray();

        int minLength = Math.min(first.length(), last.length());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < minLength; i++) {

            if (firstchar[i] == lastchar[i]) {
                sb.append(firstchar[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"caustomer", "car", "cat"};

        System.out.println(MaxPrefix(strs));
    }
}
