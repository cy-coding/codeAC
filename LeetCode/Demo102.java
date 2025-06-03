package LeetCode;

import LeetCode.Demo101.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author chuYun
 * @description: 102.二叉树的层序遍历
 * @date 2025/3/25 15:47
 */
public class Demo102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果
        List<List<Integer>> res = new ArrayList<>();
        //队列
        LinkedList<TreeNode> que = new LinkedList<>();
        if(root != null) que.offer(root);
        while (!que.isEmpty()){
            // 当前层的结果
            List<Integer> temp = new ArrayList<>();
            // 当前层长度
            int length = que.size();
            while (length > 0){
                TreeNode cur = que.poll();
                temp.add(cur.val);
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
                length--;
            }

            res.add(temp);
        }
        return res;

    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        helper(node.left, level + 1, result);
        helper(node.right, level + 1, result);
    }

}
