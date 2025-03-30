package LeetCode;

import LeetCode.Demo101.TreeNode;

import java.util.Stack;

/**
 * @author chuYun
 * @description: 98.验证二叉搜索树
 * @date 2025/3/30 21:31
 */
public class Demo98 {


    /**
     * 验证二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }

        if(node.val <= min || node.val >= max){
            return false;
        }
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }

    /**
     * //中序非递归遍历
     */
    public boolean isValidBST2(TreeNode root) {
        //前一个节点值
        long pre = Long.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.val <= pre){
                return false;
            }
            pre = cur.val;
            cur = cur.right;

        }
        return true;
    }

}
