package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chuYun
 * @description: 46.全排类
 * @date 2025/4/7 22:44
 */
public class Demo46 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        // 存放已经选择的数据
        List<Integer> cur = new ArrayList<>();

        // 递归


        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums){
        // 终止条件
        if(cur.size() == nums.length){
            // 所有元素都已经选择
            res.add(new ArrayList<>(cur));
        }
        // 处理逻辑, 确定当前位置
        for(int i = 0; i < nums.length; i++){
            // 寻找一个没有选择的
            if(!cur.contains(nums[i])){
                cur.add(nums[i]);
                // 继续向下递归
                backtracking(res,cur,nums);
                // 回溯
                // 移除最后一个加进来的
                cur.remove(cur.size() - 1);
            }
        }
    }
}
