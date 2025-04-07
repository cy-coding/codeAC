package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chuYun
 * @description: Demo207.课程表
 * @date 2025/4/7 15:40
 * 题解：<a href="https://leetcode.cn/problems/course-schedule/solutions/18806/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa">...</a>
 */
public class Demo207 {

    public static void main(String[] args) {

    }

    /**
     *  课程安排图是否是 有向无环图(DAG)。
     *  即课程间规定了前置条件，但不能构成任何环路，否则课程前置条件将不成立。
     *  思路是通过 拓扑排序 判断此课程安排图是否是 有向无环图(DAG) 。
     *  拓扑排序原理： 对 DAG 的顶点进行排序，使得对每一条有向边 (u,v)，均有 u（在排序记录中）比 v 先出现。
     *      亦可理解为对某点 v 而言，只有当 v 的所有源点均出现了，v 才能出现。
     *
     */

    /**
     * 时间O(n+m) n 节点数 m 边数
     * 空间o(n+m)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //1.统计课程安排图中每个节点的入度，生成 入度表 indegrees
        // 入度表
        int[] indegrees = new int[numCourses];
        // 邻接表
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] cp : prerequisites){
            // 先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1
            // cp[0] 入度+1
            indegrees[cp[0]]++;
            // 构建邻接表的边表
            adj.get(cp[1]).add(cp[0]);
        }

        //2.借助队列，将入度为0的节点入队
        LinkedList<Integer> queue = new LinkedList<>();
        // 将入度为0的节点入队
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        // BSF
        while (!queue.isEmpty()){
            // 出队
            int pre = queue.poll();
            // 节点数
            numCourses--;
            // 遍历当前节点的边表，将入度为0的节点入队
            for (int cur : adj.get(pre)) {
                indegrees[cur]--;
                if(indegrees[cur] == 0){
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
}
