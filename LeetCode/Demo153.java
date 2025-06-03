package LeetCode;

/**
 * @author chuYun
 * @description: 153.寻找旋转排序数组中的最小值
 * @date 2025/4/8 22:15
 */
public class Demo153 {

    public static void main(String[] args) {

    }


    /**
     * 搜索旋转排序数组的最小值
     * 数组若分成两段：第一段所有元素都大于第二段 5 6 7 || 0 1 2 3
     * 若 x > nums[n-1] 则，x 在第一段，最小值在第二段，则x在最小值的左边
     * 若 x <= nums[n-1] 则，x 在第二段，最小值在第二段，则x是最小值或者在最小值的右边
     * O(log n)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                // mid 在第一段，最小值在第二段，则mid在最小值的左边
                left = mid + 1;
            }else {
                // nums[mid] <= nums[n-1]
                // mid 在第二段，最小值在第二段，则mid是最小值或者在最小值的右边
                right = mid;
            }
        }
        return nums[left];
    }
}
