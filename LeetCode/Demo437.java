package LeetCode;
import LeetCode.Demo101.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chuYun
 * @description: 437.路径总和III
 * @date 2025/4/1 20:29
 *  题解：<a href="https://leetcode.cn/problems/path-sum-iii/solutions/2885224/javapython3cqian-zhui-he-dfser-cha-shu-s-2v8f">...</a>
 */
public class Demo437 {

    /**
     *
     * 时间O(n)
     * @param root
     * @param targetSum
     * @return
     */


    public int pathSum(TreeNode root, int targetSum) {

        // key 前缀和  value 出现次数
        HashMap<Long, Integer> map = new HashMap<>();
        // 从根节点开始进行前序遍历，前缀和初始为 0
        map.put(0L, 1);
        return dfs(root, map, 0, targetSum);

    }

    // 定义递归函数
    public int dfs(TreeNode root, Map<Long, Integer> map, long preSum, int targetSum){

        // 空结点直接返回0
        if(root == null){
            return 0;
        }

        // 非空节点，首先跟新根节点到当前节点的路径和 preSum
        int count = 0;
        preSum += root.val;
        // 判断是否满足条件
        count = map.getOrDefault(preSum - targetSum, 0);
        // 将当前前缀和加入map中
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        // 继续对当前节点的左孩子和右孩子进行递归处理
        count += dfs(root.left, map, preSum, targetSum);
        count += dfs(root.right, map, preSum, targetSum);
        // 当前节点已经处理完毕，需要返回上一级节点，需要将它对应的前缀和从哈希表中移除
        map.put(preSum, map.getOrDefault(preSum, 0) - 1);

        return count;

    }
}
