package LeetCode;

/**
 * @author chuYun
 * @description: 200. 岛屿数量
 * @date 2025/4/7 10:56
 */
public class Demo200 {



    public int numIslands(char[][] grid) {

        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i ,j);
                    count++;
                }
            }
        }

        return count;

    }


    /**
     * 我们需要在所有值为 1 的陆地格子上做 DFS 遍历。每走过一个陆地格子，就把格子的值改为 2，这样当我们遇到 2 的时候，就知道这是遍历过的格子了。也就是说，每个格子可能取三个值：
     * 0 —— 海洋格子
     * 1 —— 陆地格子（未遍历过）
     * 2 —— 陆地格子（已遍历过）
     * @param grid
     * @param r
     * @param c
     */

    private void dfs(char[][] grid, int r, int c){
        // 终止条件
        // 如果坐标 (r, c) 超出了网格范围，直接返回
        if(!inArea(grid, r, c)){
            return;
        }

        // 不是岛屿，直接返回，同时避免重复遍历
        if(grid[r][c] != '1'){
            return;
        }

        // 将遍历过的格子，标记为2，避免重复遍历
        grid[r][c] = '2';

        // 递归工作
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);

    }

    /**
     * 判断坐标(r,c)是否在网格中
     */
    boolean inArea(char[][] grid, int r, int c){

        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
