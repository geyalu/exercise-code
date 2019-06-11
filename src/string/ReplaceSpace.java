package string;

public class ReplaceSpace {

    public static String replaceSpace(String source) {
        if (source == null || source.length() == 0) {
            return source;
        }

        char[] src = source.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (char c : src) {
            if (String.valueOf(c).equals(" ")) {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We Are Happy"));
    }
}
