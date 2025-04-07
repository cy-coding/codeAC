package LeetCode;

import java.util.LinkedList;

/**
 * @author chuYun
 * @description: 994.腐烂的橘子
 * @date 2025/4/7 14:42
 */
public class Demo994 {

    public static void main(String[] args) {
        int[][] dir ={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(dir));
    }

    /**
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。
     * 翻译一下，实际上就是求腐烂橘子到所有新鲜橘子的最短路径--BFS
     */


    public static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        LinkedList<int[]> queue = new LinkedList<>();
        // 新鲜橘子的数量
        int count = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                }else if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // time 分钟数--腐蚀轮数
        int time = 0;
        while (count > 0 && !queue.isEmpty()){
            time++;
            // 当前存储
            int length = queue.size();
            while (length > 0){
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if(r-1 >= 0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    count--;
                    queue.offer(new int[]{r-1, c});
                }
                if(r+1 < m && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    count--;
                    queue.offer(new int[]{r+1, c});
                }
                if(c-1 >= 0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    count--;
                    queue.offer(new int[]{r, c-1});
                }
                if (c+1 < n && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.offer(new int[]{r, c+1});
                }
                length--;

            }

        }

        // 判断
        if(count > 0){
            return -1;
        }else {
            return time;
        }
    }

}
