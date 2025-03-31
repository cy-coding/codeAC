package LeetCode;
import LeetCode.Demo101.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chuYun
 * @description: 199.二叉树的右视图
 * @date 2025/3/31 9:39
 */
public class Demo199 {

    public static void main(String[] args) {

    }

    /**
     * 层序遍历，记录每层最后一个节点即可
     * @param root
     * @return
     */

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();

        if(root != null) que.offer(root);
        while (!que.isEmpty()){
            int length = que.size();
            while (length > 0){
                TreeNode cur = que.poll();
                if(length == 1){
                    res.add(cur.val);
                }
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
                length--;
            }
        }

        return res;

    }
}
