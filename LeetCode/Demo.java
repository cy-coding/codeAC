package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chuYun
 * @description: 94.二叉树的中序遍历
 * @date 2025/3/24 17:20
 */
public class Demo {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        Integer[] nums = new Integer[]{1,null,2,null,null,3,null};
        TreeNode root = createBT(nums, 1);
        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
    }

    /**
     * 二叉树的中序遍历
     * 左根右
     * @param root
     * @return
     */

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            //当前节点或者栈不为空，则进行遍历
            while (cur != null){
                //当前节点不为空
                //当前节点以及左孩子入栈
                stack.push(cur);
                cur = cur.left;
            }
            //出栈后，栈中压入的是当前节点和左孩子
            cur = stack.pop();
            res.add(cur.val); // 访问当前节点
            cur = cur.right;
        }
        return res;
    }

    /**
     * 构建二叉树
     * @param arr 传入数组
     * @param i 初始时候传入的i==1
     * @return
     */
    public static TreeNode createBT(Integer[] arr, int i){
        // 1.结束递归条件
        if(i > arr.length || arr[i-1] == null){
            //i >= arr.length 数组遍历结束
            return null;
        }
        // 2.一个结点的建立，空或者建立结点
        TreeNode root = new TreeNode(arr[i - 1]); //根结点
        // 3.递归
        // 根从1开始标记的话1 2 4 5 6
        root.left = createBT(arr, 2*i); //递归建立左孩子结点
        root.right = createBT(arr, 2*i+1); //递归建立右孩子结点
        return root;
    }

}
