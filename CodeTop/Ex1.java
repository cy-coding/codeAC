package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chuYun
 * @description: 1.两数之和
 * @date 2025/6/3 21:17
 */
public class Ex1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
