package Tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/25 15:49
 */
public class TreeTraversal {

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
        //输入
        Integer[] nums = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = createTree(nums, 1);
        //inorderTraversal(root);
        List<Integer> res1 = new ArrayList<>();
        preTraversal(root, res1);
        System.out.println("前序遍历："+res1);
        System.out.println("前序非递归遍历："+preTraversal(root));
        List<Integer> res2 = new ArrayList<>();
        inTraversal(root, res2);
        System.out.println("中序递归遍历："+res2);
        System.out.println("中序非递归遍历："+inTraversal(root));
        List<Integer> res3 = new ArrayList<>();
        postTraversal(root, res3);
        System.out.println("后序递归遍历："+res3);
        System.out.println("后序非递归遍历："+postTraversal(root));

    }


    //二叉树的构建
    public static TreeNode createTree(Integer[] arr, int i){

        if(i > arr.length || arr[i-1] ==null){
            //
            return null;
        }

        TreeNode root = new TreeNode(arr[i-1]);
        root.left = createTree(arr, 2*i);
        root.right = createTree(arr, 2*i+1);
        return  root;
    }


    //前序遍历--递归

    public static void preTraversal(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preTraversal(root.left, res);
        preTraversal(root.right, res);
    }

    //前序遍历--迭代
    public static List<Integer> preTraversal(TreeNode root){
        // 结果
        List<Integer> res = new ArrayList<>();
        //遍历栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur !=null || !stack.isEmpty()){
            while (cur != null){
                res.add(cur.val); //访问
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }


    //中序遍历--递归

    public static void inTraversal(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inTraversal(root.left, res);
        res.add(root.val);
        inTraversal(root.right, res);
    }

    //中序遍历--迭代
    // 左根右
    public static List<Integer> inTraversal(TreeNode root){
        // 结果
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    //后续遍历--递归
    //左右根
    public static void postTraversal(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postTraversal(root.left, res);
        postTraversal(root.right, res);
        res.add(root.val);
    }

    public static List<Integer> postTraversal(TreeNode root){
        // 存储后序遍历的结果
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Stack<TreeNode> stack1 = new Stack<>(); //第一个栈用于存储遍历的节点
        Stack<TreeNode> stack2 = new Stack<>(); //第二个栈用于存储逆序的遍历结果
        stack1.push(root); // 先把根节点压入 stack1

        while (!stack1.isEmpty()){
            TreeNode cur = stack1.pop();
            //当前节点如入栈
            stack2.push(cur);
            //左孩子
            if(cur.left != null) stack1.push(cur.left);
            //右孩子
            if(cur.right != null) stack1.push(cur.right);

            //stack1 的入栈顺序 根左右
            //stack2 的入栈顺序 根右左
            //stack2 的出栈顺序 左右根
        }
        //stack 出栈顺序刚好是左右根
        while (!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }


    //层序遍历
    public List<List<Integer>> levelTraversal(TreeNode root){

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while (!queue.isEmpty()){
            // 当前层的结果
            List<Integer> temp = new ArrayList<>();
            int length = queue.size(); //当前层长度
            while (length > 0){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                length--;
            }
            res.add(temp);
        }
        return res;
    }
}
