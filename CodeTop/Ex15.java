package CodeTop;

import java.util.*;

/**
 * @author chuYun
 * @description: 15.三数之和
 * @date 2025/6/3 16:57
 */
public class Ex15 {

    /**
     * 排序+双指针
     * 先排序--获得有序数组
     * 三个指针：k最小，双指针i，j分别设在数组的两端
     * 双指针i,j交替向中间移动，记录
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        // 结果
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int k = 0; k < nums.length - 2; k++){
            // 第一个小于0，直接返回
            if(nums[k] > 0) break;
            //
            if(k > 0 && nums[k] == nums[k-1]){
                // 重复元素不加入计算
                continue;
            }
            // 在k的右半部进行寻找
            int i = k+1;
            int j = nums.length-1;
            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    // 小于0,找一个大的
                    i++;
                } else if (sum > 0) {
                    j--;
                }else {
                    // 找到合适
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j]==nums[j-1]) j--;
                    // 1 2 2 3 这时候到2了
                    i++;
                    j--;
                }
            }


        }
        return res;
    }
}
