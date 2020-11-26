import java.util.*;
public class BucketSort_prac {
    public static void main(String[] args) {
        int K = 3;
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<10;i++){
            list.add(sc.nextInt());
        }
        for(int i:list){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer>[] bucket = new ArrayList[11];
        for(int i : map.keySet()){
            int freq = map.get(i);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        List<Integer> topK = new ArrayList<>();
        for(int i = bucket.length-1; i > 0&& topK.size()<K ;i-- ){
            if(bucket[i]==null)continue;
            if(bucket[i].size()<=K-topK.size()){
                topK.addAll(bucket[i]);
            }else {
                topK.addAll(bucket[i].subList(0,K-topK.size()));
            }
        }
        for(int i : topK){
            System.out.print(i);
        }

    }
}
