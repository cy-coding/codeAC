package Sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chuYun
 * @description: 排序学习
 * @date 2024/6/26 14:13
 */
public class SortStudy {

    public static void main(String[] args) {

        int[] test1 = new int[]{1, 5, 16, 13, 2};
        System.out.println(Arrays.toString(test1));
        System.out.println("bubble_sort:"+Arrays.toString(bubble_sort(test1)));
        System.out.println("select_sort:"+Arrays.toString(select_sort(test1)));
        System.out.println("insert_sort:"+Arrays.toString(insert_sort(test1)));
        System.out.println("quick_sort:"+Arrays.toString(quick_sort(test1, 0, 4)));
    }


    /**
     * 冒泡排序
     * @param nums 传入待排序数组
     * @return 返回值
     */
    public static int[] bubble_sort(int[] nums){
        int n = nums.length;
        boolean exchange;
        for(int i = 0; i < n-1; i++){
            //外循环是排序趟数，最多进行n-1趟排序
            //内循环是一趟排序中进行交换
            exchange = false;
            for(int j = 0; j < n-i-1; j++){
                if(nums[j] > nums[j+1]){
                    //交换位置
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    exchange = true;
                }
            }
            if(!exchange) return nums;
        }
        return nums;
    }

    /**
     * 选择排序
     * @param nums 待排序数组
     * @return 返回值
     */
    public static int[] select_sort(int[] nums){
        /*
          算法思想：
          每次从未排序部分选择一个最小的放到已排序部分最后
         */
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            //外循环是轮次
            int min_loc = i; //定位未排序部分最小数的下标
            //0--i-1 是有序的，i--n-1是无序的
            for(int j = i+1; j < n; j++){
                if(nums[j] < nums[min_loc]) min_loc = j;
            }
            //min_loc已经定位到未排序部分最下值
            if(min_loc != i){
                int temp = nums[i];
                nums[i] = nums[min_loc];
                nums[min_loc] = temp;
            }
        }
        return nums;
    }


    /**
     * 插入排序
     * @param nums 待排序数组
     * @return 返回排序后的数组
     */
    public static int[] insert_sort(int[] nums){
        int n = nums.length;
        for(int i = 1; i < n; i++){
            int preIndex = i-1; //有序部分遍历下标
            int current = nums[i]; //待排序元素
            while(preIndex >= 0 && current < nums[preIndex]){
                //已排序数组，数组元素向后移动
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            //跳出循环
            //current >= nums[preIndex] 待插入位置preIndex+1
            //prIndex = -1
            nums[preIndex + 1] =current;
        }
        return nums;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * 快速排序的划分过程
     * @param nums 待排序数组
     * @param low  低下标
     * @param high  高下标
     * @return 返回的是确定最终位置元素的下标
     */
    public static int partition(int[] nums, int low, int high){
        //采用随机元素法取枢纽值
        int pivotIndex = ThreadLocalRandom.current().nextInt(high-low+1) + low;
        int pivot = nums[pivotIndex]; //枢纽值
        swap(nums, low, pivotIndex);  //交换元素位置

        while(low < high){
            while(low < high && nums[high] > pivot){
                high--;
            }
            //找到一个比枢纽值小的
            nums[low] = nums[high];
            while(low < high && nums[low] < pivot){
                low++;
            }
            //找到一个比枢纽值大的
            nums[high] = nums[low];
        }
        //跳出循环 low==high,最终枢纽值的位置
        nums[low] = pivot;
        return low;
    }
    /**
     * 快速排序
     * @param nums 待排序数组
     * @param low  低下标
     * @param high  高下标
     * @return 返回的是确定最终位置元素的下标
     */
    public static int[] quick_sort(int[] nums, int low, int high){
        if(low < high){
            int pivotIndex = partition(nums, low, high);
            quick_sort(nums,low,pivotIndex-1);
            quick_sort(nums,pivotIndex+1,high);
        }
        return nums;
    }



}
