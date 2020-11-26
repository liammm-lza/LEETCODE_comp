/*给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
给定的字符串只含有小写英文字母，并且长度不超过10000。*/
import java.util.*;
public class Q459 {
    public static void main(String[] args) {
        System.out.print(repeatedSubstringPattern("abaaabaac"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        //i为子串长度，这步类似于寻找s.length的因数

        for (int i = 1; i < s.length() ; i++) {
            if (s.length() % i == 0) {
                String t = s.substring(0, i);
                boolean flag = true;
                for (int j = i; j + i <= s.length(); j += i) {
                    String r = s.substring(j, j + i);
                    if (!t.equals(s.substring(j, j + i))) {
                        //如果构成失败，return false
                        flag = false;
                        break;
                    }
                }
                if(flag) return true;
            }
        }
        return false;
    }
}
