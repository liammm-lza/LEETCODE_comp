import java.util.*;
public class Q347_bucketSort {
    public static void main(String[] args) {
        int[] array = {1,1,1,2,3};
        int k = 2;
        firstKFreq(array,k);
    }
    public static void firstKFreq(int[] nums, int k){
       // List<Integer> nums = new ArrayList<>(a.length);
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        Map<Integer,Integer> freqMap = new HashMap<>(nums.length);
       /* for(int i = 0; i< a.length;i++){
            nums.add(a[i]);
        }*/
        for(int num: nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        for(int key :freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq]==null) bucket[freq]=new ArrayList<>();
            bucket[freq].add(key);
        }
        List topK = new ArrayList<>();
        for(int i = bucket.length-1;i>=0&&topK.size()<k;i--){
            if(bucket[i]==null)continue;
            if(bucket[i].size()<=k-topK.size()){
                topK.addAll(bucket[i]);
            }else {
                topK.addAll(bucket[i].subList(0,k-topK.size()));
            }

        }for(Object i : topK) {
            System.out.print(i + " ");
        }
    }
}
