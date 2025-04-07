package LeetCode;
import LeetCode.Demo101.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuYun
 * @description: 105.从前序与中序遍历序列构造二叉树
 * @date 2025/4/1 17:44
 */
public class Demo105 {

    public static void main(String[] args) {

    }

    /**
     * 从前序与中序遍历序列构造二叉树
     * 1.从前序序列中找到树的根节点 root
     * 2.在中序序列中将中序划分为 左子树 根节点 右子树
     * 3.根据中序遍历中的左（右）子树的节点数量，可将 前序遍历 划分为 [ 根节点 | 左子树 | 右子树 ]
     * 算法流程：
     * 递推参数： 根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right 。
     * 终止条件： 当 left > right ，代表已经越过叶节点，此时返回 null 。
     * 递推工作：
     *  1.建立根节点 node ： 节点值为 preorder[root] 。
     *  2.划分左右子树： 查找根节点在中序遍历 inorder 中的索引 i
     *  3.构建左右子树： 开启左右子树递归。
     * @param preorder 前序序列 [ 根节点 | 左子树 | 右子树 ]
     * @param inorder 中序序列 [ 左子树 | 根节点 | 右子树 ]
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) { // 空节点
            return null;
        }
        int leftSize = indexOf(inorder, preorder[0]); // 左子树的大小
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize); //左子树
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n); //右子树
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize); //左子树
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n); //右子树
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        // 当前节点
        return new TreeNode(preorder[0], left, right);
    }

    // 返回 x 在 a 中的下标，保证 x 一定在 a 中
    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }

}
