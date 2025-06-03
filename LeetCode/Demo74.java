package LeetCode;

/**
 * @author chuYun
 * @description: 74.搜索二维矩阵
 * @date 2025/4/14 9:31
 */
public class Demo74 {


    /**
     * 将二维数组按行展开成为一维递增数组，进行二维查找即可
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int high = m * n - 1;
        int low = 0;
        while (low <= high){
            // 一维数组中的下标
            int mid = (high - low) / 2 + low;
            // 转为二维数组
            int x = matrix[mid/n][mid%n];
            if(x < target){
                low = mid + 1;
            }else if( x > target){
                high = mid - 1;
            }else {
                return true;
            }
        }
        // 跳出循环，没有发现
        return false;

    }
}
