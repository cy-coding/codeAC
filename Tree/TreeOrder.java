package Tree;


import java.util.*;

public class TreeOrder {

    public static void main(String[] args) {
        //输入
        Integer[] nums = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = createBT(nums, 0);
        //inorderTraversal(root);
        List<Integer> res1 = new ArrayList<>();
        preOrder(root, res1);
        System.out.println("前序遍历："+res1);
        System.out.println("前序非递归遍历："+preOrder(root));
        List<Integer> res2 = new ArrayList<>();
        inOrder(root, res2);
        System.out.println("中序递归遍历："+res2);
        System.out.println("中序非递归遍历："+inOrder(root));

    }

    /**
     *
     * @param arr 传入数组
     * @param i 下标，初始化为0
     * @return 返回根结点
     */
    public static TreeNode createBT(Integer[] arr, int i){
        // 1.结束递归条件
        if(i >= arr.length || arr[i] == null){
            //i >= arr.length 数组遍历结束
            return null;
        }
        // 2.一个结点的建立，空或者建立结点
        TreeNode root = new TreeNode(arr[i]); //根结点
        // 3.递归
        // 根从0开始标记的话0 1 2 4 5 6
        root.left = createBT(arr, 2*i+1); //递归建立左孩子结点
        root.right = createBT(arr, 2*i+2); //递归建立右孩子结点
        return root;
    }

    /**
     * 前序递归遍历
     * @param root 根节点
     * @param res 遍历结果List
     */
    public static void preOrder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }


    /**
     * 中序递归遍历
     * @param root 根节点
     * @param res 遍历结果List
     */
    public static void inOrder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    /**
     * 后序递归遍历
     * @param root 根节点
     * @param res 遍历结果List
     */
    public static void postOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    /**
     *
     * 前序非递归遍历
     * @param root 根结点
     * @return 遍历结果List
     */
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>(); //存放遍历结果
        //遍历栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            while (current != null){
                res.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop(); //获取栈顶结点
            current = current.right;
        }
        return res;
    }

    /**
     * 中序非递归遍历
     * @param root 根结点
     * @return 遍历结果List
     */
    public static List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                // 当前结点以及左孩子入栈
                stack.push(current);
                current = current.left;
            } //出栈后，栈中压入的是当前结点和左孩子
            current = stack.pop(); //栈顶结点
            res.add(current.val); //访问当前结点
            current = current.right; //访问右子树
        }
        return res;
    }

    /**
     * 层序遍历
     * @param root 根结点
     * @return 返回值
     */
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>(); //当前层的数据
            int length  = queue.size(); //当前层的长度
            for(int i = length; i > 0; i--){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }



    // 简单的中序遍历打印树，以验证树的结构
    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
