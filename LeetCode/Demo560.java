package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuYun
 * @description: 560. 和为K的子数组
 * @date 2025/3/11 16:46
 */
public class Demo560 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,-1,0};
        int k = 0;
        System.out.println(new Demo560().subarraySum(nums, k));
    }

    /**
     * 分析：
     * 1.连续数组：若计算前缀和s[i] 则当s[i]-s[j]=k,则证明存在一段满足条件的子数组序列
     * 定义一个哈希表，key-前缀和，value：前缀和相同出现的次数
     * 时间O(n)
     * @param nums
     * @param k
     * @return
     */

    public int subarraySum(int[] nums, int k){

        int count = 0;
        int[] sum = new int[nums.length+1];
        //计算前缀和
        for(int i=0; i<nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        //定义哈希表来存储对应关系
        // key:sum[i] value 出现的次数
        Map<Integer, Integer> map = new HashMap<>(nums.length+1);
        //开始遍历前缀和，寻找满足条件的数组
        for(int sj : sum){
            //若当前key存在对应的value则返回，否则返回0
            //s[i]-s[j]=k,则证明存在一段满足条件的子数组序列
            count += map.getOrDefault(sj-k, 0);
            /**
             * merge 方法的工作方式如下：
             *
             * 如果 key 不存在于 HashMap 中，那么 value 将被设置为与 key 关联的值。
             * 如果 key 已经存在于 HashMap 中，那么 remappingFunction 将被调用，
             *      传入当前值和新的值，返回一个新的值，这个新的值将替换原来的值。这里选择的是和
             */
            map.merge(sj, 1, Integer::sum);
        }

        return count;
    }
}
