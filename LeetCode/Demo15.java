package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author chuYun
 * @description: 15. 三数之和
 * @date 2025/3/8 17:14
 */
public class Demo15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};

        System.out.println(new Demo15().threeSum(nums));

    }

    /**
     * 三数之和分析：
     * 1.满足和为0 --》 三个不确定数无法计算，可以确定一个，探究另外两个
     *      三元组不能重复 --》 需要一些限定条件来把重复的筛选出去
     * 2.为了简单，我们可以先将数组升序排列
     *      确定一个nums[i] ,将其作为三个中最小值
     *          nums[i] < nums[left] < nums[right]
     *          nums[i]可以作为去重条件之一，从左到右遍历，出现重复的可以跳过
     * 时间O(n^2)
     *
     * @param nums
     * @return
     */


    public List<List<Integer>> threeSum(int[] nums) {

        //存储最终结果
        List<List<Integer>> res = new ArrayList<>();
        //升序
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            if(nums[i] > 0) break;
            //去重条件
            if(i > 0 && nums[i] == nums[i-1]) continue;

            //开始寻找另外两个
            int left=i+1, right=nums.length-1;
            while (left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    // 存储三元组
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    res.add(list);

                    // 继续选择，找到不同的三元组再次判断
                    // 这个nums[i]已经确定，所以接下来的组合中，不能还有和上个组合一样的元素
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                }
                if(nums[i] + nums[left] + nums[right] < 0){
                    //找一个正数
                    left++;
                }else {
                    //找一个负数
                    right--;
                }
            }

        }
        return res;
    }
}
