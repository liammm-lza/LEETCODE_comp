import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 你的面前有一堵矩形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
 *
 * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
 *
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
 *
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的
 */
public class Q554 {
    public static void main(String[] args) {
        int[][] nums;
        nums = new int[][]{{1}, {1},{1},{1},{1},{1}};
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            List current = new LinkedList();
            for (int j = 0; j < 1; j++) {
                current.add(j,nums[i][j]);
            }
            list.add(current);
        }
        System.out.println(leastBricks(list));
    }
    public static int leastBricks(List<List<Integer>> wall) {
        boolean flag = true;
        for (int i = 0; i < wall.size()-1; i++) {
            List current = wall.get(i);
            List next = wall.get(i+1);
            if(!comp(current,next)) flag =false;
        }if(flag) return wall.size();
        int count=0;
        Map map = new HashMap<>();
        for (Integer i : wall.get(0)) {
            count+=i;
        }
        for (int i = 1; i < count-1; i++) {
            int value=0;
            for (List l:wall) {
                if(countBricks(l,i)) value++;
            }
            map.put(i,wall.size()-value);
        }
        int min = 99999;
        for (Object i : map.keySet()) {
            int val = (int) map.get(i);
            if (val<min) min = val;
        }
        return min;
    }
    public static boolean countBricks(List<Integer> l, int num){
        int index = 0;
        for (Integer i : l) {
            index +=i;
            if(index == num) return true;
            if(index>num) return false;
        }
        return false;
    }
    private static boolean comp(List a,List b){

        return (a.toString().equals(b.toString()));
    }
}
