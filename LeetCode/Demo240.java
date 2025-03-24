package LeetCode;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/16 22:06
 */
public class Demo240 {

    public static void main(String[] args){

    }

    /**
     * 题目：
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
     * 该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 1234
     * 2345
     *
     * 分析：对每行进行二分查找
     * 时间O(mlogn)
     * @param matrix
     * @param target
     * @return
     */

    public boolean searchMatrix(int[][] matrix, int target) {

        boolean ans = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int[] row : matrix){
            int index = binarySearch(row, target);
            if(index >= 0){
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     * 适用于有序的序列
     * 时间0(nlogn)
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int low = 0, high = nums.length-1;

        while (low <= high){
            int mid = (high - low) / 2 + low;
            if(nums[mid] < target)
                low = mid + 1;
            else if(nums[mid] > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * 时间O(m+n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1; // 从右上角开始
        while (i < matrix.length && j >= 0) { // 还有剩余元素
            if (matrix[i][j] == target) {
                return true; // 找到 target
            }
            if (matrix[i][j] < target) {
                i++; // 这一行剩余元素全部小于 target，排除
            } else {
                j--; // 这一列剩余元素全部大于 target，排除
            }
        }
        return false;
    }
}
