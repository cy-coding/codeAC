package Graph;

/**
 * @author chuYun
 * @description: 岛屿类问题的通用解法、DFS 遍历框架
 * @date 2025/4/7 11:03
 * 题解：<a href="https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-">...</a>
 */
public class DFSCommon {

    void dfs(int[][] grid, int r, int c){
        // 终止条件
        // 如果坐标 (r, c) 超出了网格范围，直接返回
        if(!inArea(grid, r, c)){
            return;
        }


        // 递归工作
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);

    }

    /**
     * 判断坐标(r,c)是否在网格中
     * @param grid
     * @param r
     * @param c
     * @return
     */
    boolean inArea(int[][] grid, int r, int c){

        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
