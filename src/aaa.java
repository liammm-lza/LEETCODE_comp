import java.util.HashSet;

public class aaa {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0, index = -1,n=s.length();
        for(int i = 0; i < n; ++i){
            if(i!=0) {
                set.remove(s.charAt(i-1));
            }
            while(index+1<n&&!set.contains(s.charAt(index+1))){
                set.add(s.charAt(index+1));
                ++index;
            }
            max = Math.max(max,index-i+1);
        }
        return max;
    }
}
