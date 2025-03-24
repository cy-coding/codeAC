package LeetCode;

import java.util.Arrays;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/14 22:08
 */
public class Demo238 {

    public static void main(String[] args){
        int[] nums = new int[]{-1,1,0,-3,3};
        System.out.printf(Arrays.toString(new Demo238().productExceptSelf(nums)));
    }

    /**
     * 1234
     * 分析：使用两个辅助数组，前缀乘积pre[]和后缀乘积next[]
     * 算法设计：
     * 1.遍历数组，统计前缀乘积
     * 2.遍历数组，统计后缀乘积
     * 3.遍历数组，计算结果
     * 时间O(n)
     * @param nums
     * @return
     */

    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        int[] pre = new int[n];
        int[] next = new int[n];
        pre[0] = 1;
        next[n-1] = 1;
        //计前缀乘积
        for(int i = 1; i<n; i++){
            pre[i] = pre[i-1] * nums[i-1];
        }
        //统计后缀乘积
        for(int i = n-2; i >= 0; i--){
            next[i] = next[i+1] * nums[i+1];
        }
        //计算结果
        for(int i = 0; i<n; i++){
            answer[i] = pre[i] * next[i];
        }

        return answer;
    }
}
