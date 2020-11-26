package huaqi;


import java.util.HashMap;
import java.util.Map;

public class test1 {
    public static void main(String[] args) {
       System.out.println(solution("Sat",23));
    }
    public static String solution(String S, int K) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Mon");
        map.put(2,"Tue");
        map.put(3,"Wed");
        map.put(4,"Thu");
        map.put(5,"Fri");
        map.put(6,"Sat");
        map.put(7,"Sun");
        int val=0;
        switch (S){
            case "Mon":
                val = 1;
                break;
            case "Tue":
                val = 2;
                break;
            case "Wed":
                val = 3;
                break;
            case "Thu":
                val = 4;
                break;
            case "Fri":
                val = 5;
                break;
            case "Sat":
                val = 6;
                break;
            case "Sun":
                val = 7;
                break;
        }
        int date = (val+K)%7;
        return map.get(date);

    }
}
