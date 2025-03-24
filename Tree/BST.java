package Tree;

/**
 * @author chuYun
 * @description: 二叉搜索树
 * @date 2024/6/27 23:07
 */
public class BST {

    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树搜索目标值
     * @param root 根节点指针
     * @param target 待搜索值
     * @return 返回结点指针
     */
    public static TreeNode searchBST(TreeNode root, int target){
        if(root == null || root.val == target){
            return root;
        }
        if(target < root.val){
            //搜索左子树
            return searchBST(root.left, target);
        }else{
            //搜做右子树
            return searchBST(root.right, target);
        }
    }

    /**
     * 验证二叉搜索树
     * @param root 根结点指针
     * @return 返回布尔值
     */
    public static long pre = Long.MIN_VALUE; //存储最小值
    public static boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        //左
        if(!isValidBST(root.left)){
            return false;
        }
        //判断当前结点值是否大于前一个结点
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);

    }
}
