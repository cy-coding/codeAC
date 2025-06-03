package CodeTop;

import java.util.Random;

/**
 * @author chuYun
 * @description: 排序数组-快速排序
 * @date 2025/6/3 9:58
 */
public class Ex912 {


    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快速排序函数
    private void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        // 对数组进行分区，获取基准元素最终位置
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex-1);
        quickSort(nums, pivotIndex+1, right);
    }
    // 分区函数
    private int partition(int[] nums, int left, int right){
        // 随机选择基准
        int pivotIndex = new Random().nextInt(right-left+1) + left;
        int pivot = nums[pivotIndex];
        // 基准值移动到最左边
        swap(nums, left, pivotIndex);
        int i = left; // 左
        int j = right; // 右
        while (i < j){
            // 从右到左找到第一个小于pivot的元素
            while (i < j && nums[j] >= pivot){
                j--;
            }
            // 从左到右找到第一个大于pivot的元素
            while (i < j && nums[i] <= pivot){
                i++;
            }
            if(i < j){
                swap(nums, i, j);
            }
        }
        // 当i==j,交换nums[i]和基准元素
        swap(nums, left, i);
        return i;
    }

    // 交换函数
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }
}
