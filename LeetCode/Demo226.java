package LeetCode;

import java.util.*;

/**
 * @description: 226翻转二叉树
 * @author chuYun
 * @date 2025/3/25 22:17
 */
public class Demo226 {

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
     * 时间O(n)
     * 空间O(n)
     * @param root
     * @return
     */

    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }

        // 交换当前节点左右孩子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left); //翻转左子树
        invertTree(root.right); //翻转右子树
        return root;

    }

    /**
     * 非递归--层序遍历
     * 时间O(n)
     * @param root
     * @return
     */

    public TreeNode invertTree2(TreeNode root){

        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);

        while (!queue.isEmpty()){
            // 每次都从队列中拿一个节点，并交换这个结点到 左右子树
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            cur.left = cur.right;
            cur.right = left;
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }
        return root;
    }


}
