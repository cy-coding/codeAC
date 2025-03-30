package LeetCode;

import Tree.TreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author chuYun
 * @description: 104.二叉树的最大深度
 * @date 2025/3/25 15:02
 */
public class Demo104 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {

    }

    /**
     * 二叉树的最大深度
     * 二叉树的 最大深度 是指从 根节点 到 最远叶子节点 的最长路径上的 节点数。
     * 方法1：递归--自低向上
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 终止条件，null 时后说明越过叶子节点，返回0
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }

    /**
     * 方法2；自上向下
     * 层序遍历的方法，每下一层，记录一下
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {

        if(root == null){
            return 0;
        }
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size(); //当前层长度
            while (length > 0){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                length--;
            }
            res++;
        }

        return res;
    }







    /**
     * 二叉树的构建
     * @param nums
     * @param i -- 传入1
     * @return
     */
    public TreeNode createTree(Integer[] nums, int i){

        if(i > nums.length || nums[i-1] == null){
            return null;
        }

        TreeNode root = new TreeNode(nums[i-1]);
        root.left = createTree(nums, 2*i);
        root.right = createTree(nums, 2*i+1);
        return root;

    }

}
