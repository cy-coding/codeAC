package LeetCode;

import java.util.Arrays;

/**
 * @author chuYun
 * @description: 53.最大子数组和
 * @date 2025/3/11 17:17
 */
public class Demo53 {

    public static void main(String[] args) {

        int[] nums = new int[]{-1};
        System.out.println(new Demo53().maxSubArray(nums));

    }

    /**
     * 最大和的连续数组，计算前缀和s[i] , 计算s[j]-s[i]最大即可,
     * 在保证相对顺序的情况下j>i，找出一个最大的s[j]和最小的s[i]即可
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int preSum = 0; //当前前缀和
        int minPreSum = 0; //最小前缀和
        //计算数组前缀和
        for(int x : nums){
            preSum += x;
            //当前前缀和-最小前缀和看看是否需要变化
            max = Math.max(max, preSum - minPreSum);
            //维护最小前缀和
            //每到一个前缀和，比较一下，当前小还是之前的小
            minPreSum = Math.min(minPreSum, preSum);
        }
        return max;
    }

}
