package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chuYun
 * @description: 22.括号生成
 * @date 2025/4/8 22:13
 */
public class Demo22 {

    public static void main(String[] args) {

    }

    /**
     * 括号生成
     * @param
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        backtrack(res, cur, 0, 0, n);

        return res;

    }

    /**
     *
     * @param res
     * @param cur 用来操作字符串
     * @param open 左括号
     * @param close 右括号
     * @param n n
     */
    public void backtrack(List<String> res, StringBuilder cur, int open, int close, int n){

        // 终止条件
        if(cur.length() == n * 2){
            // 所有元素都已经选择
            res.add(cur.toString());
            return;
        }
        if(open < n){
            // 左括号
            cur.append('(');
            backtrack(res, cur, open+1, close, n);
            // 回溯
            cur.deleteCharAt(cur.length() - 1);
        }

        if(close < open){
            // 右括号
            cur.append(')');
            backtrack(res, cur, open, close + 1, n);
            // 回溯
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
