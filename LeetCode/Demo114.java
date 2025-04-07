package LeetCode;
import LeetCode.Demo101.TreeNode;
/**
 * @author chuYun
 * @description: 114.二叉树展开为链表
 * @date 2025/3/31 10:06
 */
public class Demo114 {
    public static void main(String[] args) {

    }

    /**
     * 题解：<a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/17274/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26">...</a>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。根左右
     * 解法;
     * 1.将左子树插入到右子树的地方
     * 2.将原来的右子树接到左子树的最右边节点
     * 3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     * @param root
     */
    public void flatten(TreeNode root) {

        while (root != null){
            if(root.left == null){
                // 左子树为空，直接考虑下一个节点
                root = root.right;
            }else {
                // 找到左子树最右边节点
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                // 将原来右子树接到左子树最右边节点
                pre.right = root.right;
                // 左子树变右子树
                root.right = root.left;
                root.left = null;
                // 下一个节点
                root = root.right;
            }
        }

    }


}
