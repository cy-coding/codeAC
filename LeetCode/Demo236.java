package LeetCode;
import LeetCode.Demo101.TreeNode;
/**
 * @author chuYun
 * @description: 236.二叉树的最近公共祖先
 * @date 2025/4/3 15:04
 * 题解：<a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/240096/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu">...</a>
 */
public class Demo236 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 1.终止条件：
        // 越过叶子节点直接返回null
        // 当 root 等于 p,q ，则直接返回 root
        if(root == null || root == p || root == q){
            return root;
        }

        // 2.递推工作
        // 左子树，返回值记为Left
        // 右子树，返回值记为right
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        // 同时为空，说明 root 左右子树都不包含p,q
        if(left == null && right == null) return null;
        // left 为空，right 不为空，p,q 都不在 root 的左子树中，返回右子树
        if(left == null) return right;
        // right 为空，left 不为空, 返回左子树
        if(right == null) return left;

        //if(left != null and right != null)
        // 说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root
        return root;
    }

}
