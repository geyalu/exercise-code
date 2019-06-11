package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 回文串
 */
public class Palindrome {
    /*
    最长回文串
     */
    public static int macPalindrome(String str) {

        char[] chars = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            if (map.containsKey(c)) {
                int num = map.get(c);
                map.put(c, ++num);
            } else {
                map.put(c, 1);
            }
        }

        int length = 0;
        int flag = 0;
        for (Map.Entry entry : map.entrySet()) {
            int num = (int) entry.getValue();

            if (num % 2 == 0) {
                length += num;
            } else {
                flag = 1;
            }
        }

        return length + flag;


    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        int i =0;
        int j = s.length()-1;

        while (i<j){
            if (chars[i]==chars[j]){
                i++;
                j--;
            }else {
                return false;
            }
        }

        if (i>=j){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
//        System.out.println(macPalindrome("ccccdd"));
        System.out.println(isPalindrome("abcdqcba"));
    }

}
