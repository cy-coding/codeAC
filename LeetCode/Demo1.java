package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chuYun
 * @description: 1.两数之和
 * @date 2025/3/3 21:17
 */
public class Demo1 {

    /**
     * 分析：
     *  并且你不能使用两次相同的元素-->可以考虑使用哈希表
     *     将数组下标作为value, 数组值作为key
     *  遍历数组，构建哈希表，判断target-nums[i]是否在哈希表中
     *      如果在，则返回对应的下标
     *      否则，继续添加进Map中
     *  时间：O(n)
     *  空间：O(n)
     *
     */

    public static void main(String[] args) {

       int[] nums =  new int[]{2,7,11,15};
       int target = 9;
       Demo1 demo1 = new Demo1();
       System.out.println(Arrays.toString(demo1.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int []res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        //遍历数组，构建哈希表
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
