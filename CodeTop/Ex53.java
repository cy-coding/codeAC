package CodeTop;

/**
 * @author chuYun
 * @description: 53.最大子数组和
 * @date 2025/6/3 20:15
 */
public class Ex53 {

    /**
     * 前缀和
     * 维护当前前缀和 、最小前缀和
     *前前缀和-最小前缀 代表着一段子序列的和， 不断更新记录这个子序列和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for(int x : nums){
            // 当前前缀和
            preSum += x;
            // 结果
            res = Math.max(res, preSum - minPreSum);
            // 更新最小前缀和
            minPreSum = Math.min(minPreSum, preSum);
        }
        return res;
    }
}
