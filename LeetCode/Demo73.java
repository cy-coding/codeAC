package LeetCode;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/14 22:31
 */
public class Demo73 {

    public static void main(String[] args){

    }

    /**
     *
     * 分析：遍历一遍数组，将0元素的行号和列号记录下来
     * 将每个行号和每个列好组合，将[i,j]置为0
     * 时间O(n^2)
     * 空间O(m+n)
     *
     * @param matrix
     */
    public void setZeroes1(int[][] matrix){

        int m = matrix.length; //行数
        int n = matrix[0].length; //列数
        boolean[] row = new boolean[m]; //行记录
        boolean[] col = new boolean[n]; //列记录

        //将0元素的行号和列号记录下来
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]==0){
                    row[i]=col[j]=true;
                }
            }
        }

        // 将[i,j]置为0
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用两个标记变量
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean flagRow = false, flagCol = false;
        //预先处理第一列和第一行
        for(int i = 0 ;i<m;i++){
            if(matrix[0][i]==0){
                flagRow = true;
            }
        }
        for(int i = 0 ;i<n;i++){
            if(matrix[i][0]==0){
                flagCol = true;
            }
        }
        //将原数组的第一行和第一列当作标记数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        //

    }

}
