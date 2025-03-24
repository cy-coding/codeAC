package LeetCode;

import java.util.List;
import java.util.Scanner;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/16 21:43
 */
public class Demo54 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
    }

    /**
     *
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * @param matrix
     * @return
     */

    public List<Integer> spiralOrder(int[][] matrix) {


        return null;
    }
}
