package LeetCode;

import java.util.Arrays;

/**
 * @author chuYun
 * @description: 283.移动零
 * @date 2025/3/8 15:22
 */
public class Demo283 {

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,0,3,12};
        Demo283 demo283 = new Demo283();
        demo283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 分析：
     *  left 左指针指向当前已经处理好的序列的尾部（第一个0的位置），右指针指向待处理序列的头部，寻找不是0的数。
     *  右指针不断向右移动，每次右指针指向非零数，则将左 右指针对应的数交换，同时左指针右移。
     *  当right 遇到非零元素的
     * @param nums
     */

    public void moveZeroes(int[] nums){
        int left = 0;
        int right = 0;

        while (right < nums.length){
            if(nums[right] !=0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }



    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
