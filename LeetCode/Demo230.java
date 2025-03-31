package LeetCode;

import LeetCode.Demo101.TreeNode;

import java.util.Stack;

/**
 * @author chuYun
 * @description: 230.二叉树中第K小的元素
 * @date 2025/3/31 9:19
 */
public class Demo230 {

    public static void main(String[] args) {

    }

    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）
     * 根节点是中间节点--中序非非递归---根据出栈顺序来
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {

        int target = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()){

            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            target++;
            if(target == k){
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;

    }


}
