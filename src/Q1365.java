import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 */
public class Q1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int result = 0;
            for (int j = 0; j < nums.length; j++) {
                if(current>nums[j]) result++;
            }
            out[i] = result;
        }return out;
    }

}
