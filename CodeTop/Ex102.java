package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chuYun
 * @description: 102.二叉树的层序遍历
 * @date 2025/6/3 21:04
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Ex102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        // 结果
        List<List<Integer>> res = new ArrayList<>();
        // 队列
        LinkedList<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            // 当前层的结果
            List<Integer> cur_res = new ArrayList<>();
            while (length > 0){
                TreeNode temp = queue.poll();
                cur_res.add(temp.val);
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
                length--;
            }
            res.add(cur_res);
        }
        return res;
    }
}
