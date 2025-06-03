package CodeTop;

/**
 * @author chuYun
 * @description: 33.搜素旋转数组
 * @date 2025/6/3 21:35
 */
public class Ex33 {

    /**
     * 旋转后的数组部分有序：分成两段，每一段都是有序的，所以要找到分界
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //
            if(nums[mid] < nums[right]){
                // 说明选的值小于这一段的最大值，mid - right 是有序的
                // 划定有序序列
                if(nums[mid] < target && target <= nums[right]){
                    // target在这一段
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else{
                // left - mid是有序的
                // 划定有序序列
                if(nums[mid] > target && target >= nums[left]){
                    // target在这一段
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int minIndex = finMin(nums);
        int low;
        int high;
        // 确定搜查区间
        if(minIndex == nums.length){
            // 说明没有旋转或旋转后和以前一样
            low = 0;
            high = nums.length - 1;
        }else {
            // 数组进行了旋转
            if(target >= nums[0] && target <= nums[minIndex-1]){
                low = 0;
                high = minIndex - 1;
            }else{
                low = minIndex;
                high = nums.length - 1;
            }
        }
        // 进行二分查找
        while (low <= high){
            int mid = (high - low) / 2 + low;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] <= target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 返回最小值下标
    private int finMin(int[] nums){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int temp = nums[0];
        while (low <= high){
            int mid = (high - low) / 2 + low;
            //
            if(nums[mid] >= temp){
                // temp--nums[0] 说明mid在前半段，最小值为后半段的开头
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }


}
