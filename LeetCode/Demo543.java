package LeetCode;

import java.util.Map;

/**
 * @author chuYun
 * @description: 543.二叉树的直径
 * @date 2025/3/30 20:36
 */
public class Demo543 {

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


    int ans;
    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return ans;

    }

    private int dfs(TreeNode node){
        if(node == null){
            return -1;
        }
        // 判断左子树
        int lLen = dfs(node.left) + 1;
        // 判断右子树
        int rLen = dfs(node.right) + 1;
        ans = Math.max(ans, lLen + rLen);
        return Math.max(lLen, rLen); // 当前子树最大链长
    }

}
