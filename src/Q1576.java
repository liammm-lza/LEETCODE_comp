import java.util.*;
/* 替换字符串中的问号
* */
public class Q1576 {
    public static void main(String[] args) {
        String s = "abcd?";
        System.out.print(modifyString(s));
    }
    public static String modifyString(String s) {
        char[] ch = s.toCharArray();

        int k = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '?') {
                while ((i > 0 && ('a' + k % 26) == ch[i-1])) {
                    k++;
                }

                while (i < ch.length - 1 && ('a' + k % 26 == ch[i+1])) {
                    k++;
                }

                ch[i] = (char)('a' + (k % 26));
            }
        }

        return new String(ch);
    }
}
