/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，
 * 因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量
 *
 */

import java.util.*;


public class Q425 {
    public static void main(String[]args){
        int[][] points = {{2,3},{7,15},{5,12},{4,5},{8,13},{9,16},{5,8},{8,16},{3,4},{8,17}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
         List<int[]> list = new ArrayList<>();
        int n = points.length;
         for(int i = 0; i < n; i++){
             list.add(points[i]);
         }
         return s(list);
    }
    public static int s(List list){
        if(list.isEmpty()) return 0;
        if(list.size()==1) return 1;
        int minVal = 999999;
        for(int i = 0; i < list.size(); i++){
            List list_ = k2(i,list);
            int val = 1+s(list_);
            if(val<minVal){
                minVal = val;
            }
        }return minVal;
    }

    //返回打m时剩下的list
    public static List k2(int m, List list){
        int[] target = (int[]) list.get(m);
        list.remove(m);
        int high =target[1];
        int low = target[0];
        List<Integer>[] index = new ArrayList[high-low+1];
        for(int i = low; i <= high; i++){
            for(int j = 0; j < list.size(); j++){
                int[] current = (int[]) list.get(j);
                if(i>=current[0]&&i<=current[1]){
                    if(index[i-low]==null){
                        index[i-low] = new ArrayList<>();
                    }
                    index[i-low].add(j);
                }
            }
        }
        int index_ = 0;
        int maxSize = 0;
        for(int i = 0; i <= high-low; i++){
            if(index[i]==null) index[i] = new ArrayList<>();
            List temp = index[i];
            if(temp.isEmpty()) continue;
            if(temp.size()>maxSize){
                maxSize= temp.size();
                index_ = i;
            }
        }
        if(index[index_].isEmpty()) return list;
        List arr = index[index_];
        Collections.sort(arr);
        Collections.reverse(arr);
        for (int e :index[index_]) {
            list.remove(e);
        }
        return list;
    }


}
