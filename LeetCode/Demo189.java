package LeetCode;

import java.util.Arrays;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/14 21:46
 */
public class Demo189 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        new Demo189().rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 题目：给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * 分析：判断轮转后位置变化，找出规律： (i+k)%n
     * 1.使用辅助数组，将数组直接计算位置，存储新数组，然后将新数组在复制到旧数组
     * 2.使用翻转 1 2 3 4 5 6 7 -翻转所有- 7 6 5 4 3 2 1 -翻转[0,k-1]-5 6 7 4 3 2 1 -翻转[k-1,n-1]-5 6 7 1 2 3 4
     * @param nums
     * @param k
     */

    public void rotate(int[] nums, int k){

        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums,k, nums.length-1);

    }

    //翻转函数
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
