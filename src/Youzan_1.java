import java.util.*;
public class Youzan_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        if(StringCheck(s,t)){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

    }
    public static boolean StringCheck(String s, String t){

        if (s.equals(null)) return true;
        else {
            int index = checkChar(s.charAt(0),t);
            if(index<0){
                return false;
            }else{

                t = t.substring(index+1);
                s = s.substring(1);
                if(s.isEmpty()) return true;
                return StringCheck(s,t);

            }
        }


    }
    public static int checkChar(char c, String s){
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            char current = ch[i];
            if(c==current){
                return i;
            }
        }
        return -1;
    }
}
