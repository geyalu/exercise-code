package string;

/**
 * 字符串匹配，KMP算法
 */
public class StringMatcher {

    /*
        暴力匹配算法
     */
    public static int stringIndexOf(String source, String pattern) {

        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();

        int i = 0; //src
        int j = 0;  //ptn

        int srcLen = source.length();
        int ptnLen = pattern.length();

        int srcPos = 0;

        while (i < srcLen && j < ptnLen) {
            if (src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                srcPos++;
                i = srcPos;
                j = 0;
            }
        }

        if (j == ptnLen) {
            return srcPos;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String str = "abababdafdasabcfdfeaba";
        String pattern = "abc";

        System.out.println(stringIndexOf(str, pattern));

        System.out.println(str.indexOf(pattern));

    }

}
