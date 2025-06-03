package CodeTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chuYun
 * @description: 215.数组中第K个最大元素
 * @date 2025/6/1 16:33
 */
public class Ex215 {
    //
    public int findKthLargest(int[] nums, int k) {

        // 第K个大的数，下标为len-k
        int target = nums.length - k;
        int left = 0;
        int right = nums.length -1;
        while (true){
            int pivotIndex = partition(nums, left, right);
            if(pivotIndex == target){
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            }else {
                right = pivotIndex - 1;
            }
        }
    }

    // 分区函数
    // 我们一次划分可以确定一个元素最终位置，划分结束后枢纽位置
    private int partition(int[] nums, int left, int right){
        // 选择枢纽值
        int pivotIndex = new Random().nextInt(right - left +1) +left;
        int pivot = nums[pivotIndex];
        swap(nums, left, pivotIndex);
        int i = left;
        int j = right;
        while (i < j){
            // 右-左
            while (i < j && nums[j] >= pivot){
                j--;
            }
            while (i < j && nums[i] <= pivot){
                i++;
            }
            if(i < j){
                swap(nums, i, j);
            }
        }
        // i==j
        swap(nums,left,i);
        return i;
    }

    // 交换函数
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }
}
