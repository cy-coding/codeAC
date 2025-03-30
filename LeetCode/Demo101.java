package LeetCode;

import java.util.LinkedList;

/**
 * @author chuYun
 * @description: 101.对称二叉树
 * @date 2025/3/30 17:10
 */
public class Demo101 {

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
     *
     * @param root
     * 判断条件：树中，任意两个对称节点L，R
     * L.val = R.val 这两个堆成节点值相等
     * L.left.val = R.right.val ：即 L 的 左子节点 和 R 的 右子节点 对称。
     * L.right.val = R.left.val ：即 L 的 右子节点 和 R 的 左子节点 对称。
     *     1
     *   2   2
     *  3 4 4 3
     * @return
     */

    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode L, TreeNode R){

        // 终止条件1：同时为空，越过叶结点，堆成
        if(L == null && R == null){
            return true;
        }
        // 终止条件2：L或R只有一个越过叶结点，树不对称，返回false
        if(L == null || R == null){
            return false;
        }
        // 终止条件3:L.val != R.val 树不对称
        if(L.val != R.val){
            return false;
        }
        //递推工作：
        // 1.判断两节点 L.left 和 R.right 是否对称，
        // 2.判断两节点 L.right 和 R.left 是否对称，
        return isMirror(L.left, R.right) && isMirror(L.right, R.left);
    }

    /**
     *现在我们改用队列来实现，思路如下：
     * 首先从队列中拿出两个节点(left 和 right)比较
     * 将 left 的 left 节点和 right 的 right 节点放入队列
     * 将 left 的 right 节点和 right 的 left 节点放入队列
     * 时间复杂度是 O(n)，空间复杂度是 O(n)
     * @param root
     * @return
     */

    public boolean isSymmetric2(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        //队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<>();

        //将根节点的左 右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0){
            // 从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            // 将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);
            // 将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;

    }






}
