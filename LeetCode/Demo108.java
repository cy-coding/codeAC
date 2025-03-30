package LeetCode;

import LeetCode.Demo101.TreeNode;
/**
 * @author chuYun
 * @description: 108.有序数组转二叉搜索树
 * @date 2025/3/30 21:09
 */
public class Demo108 {



    public static void main(String[] args) {

    }

    /**
     * 构建平衡二叉搜索树
     * 二叉搜索树 binary search tree 左 < 根 < 右
     * 二叉搜索树的中序遍历是升序序列，题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right){
        // 结束递归条件
        if(left > right){
            return null;
        }

        // 选择中间位置左边
        int mid = (left + right) / 2;
        // 当前节点
        TreeNode root = new TreeNode(nums[mid]);
        // 左
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid+1, right);
        return root;
    }




}
