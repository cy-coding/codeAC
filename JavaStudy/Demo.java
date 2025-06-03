package JavaStudy;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int M = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        int[][] grid = new int[M][];
        for (int i = 0; i < M; i++) {
            String line = scanner.nextLine();
            String[] nums = line.split(" ");
            grid[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                grid[i][j] = Integer.parseInt(nums[j]);
            }
        }

        // 计算最小路径和
        int result = minPathSum(grid);
        System.out.println(result);
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // 创建dp数组
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // 填充dp数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
