package LeetCode;

/**
 * @author chuYun
 * @description: 35.搜索插入位置
 * @date 2025/4/9 22:20
 */
public class Demo35 {

    public static void main(String[] args) {

    }

    /**
     * 使用二分查找：有序的数组
     * 时间O(logn)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right){
            int m = left +  (right - left) / 2;
            if(nums[m] < target){
                // 在右半区寻找
                left = m + 1;
            }else if(nums[m] > target){
                // 在左半区寻找
                right = m - 1;
            }else {
                // 找到目标元素，返回其索引
                return m;
            }
        }
        // 跳出循没有找到位置
        // left > right
        return left;
    }
}
