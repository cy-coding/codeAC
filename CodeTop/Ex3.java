package CodeTop;

import java.util.HashMap;

/**
 * @author chuYun
 * @description: 3.无重复字符的最长子串
 * @date 2025/6/1 15:42
 */
public class Ex3 {
    /**
     * 滑动窗口
     * O(n)
     * 1. left 不动，right向右遍历
     * 2. 遇到字符将字符和下标存在哈希表中，并更新长度
     * 3. 若遇到重复字符串，则将left改变为重复字符串下一个位置，继续遍历
     * @param
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        // key 字符值 value 为字符位置
        HashMap<Character, Integer> map = new HashMap<>();

        for (int left = 0, right = 0; right < n; right++){
            char element = s.charAt(right);
            if(map.containsKey(element)){
                // 若哈希表存在，则说明遇到了相同的字符
                // 将left改变为重复字符串下一个位置
                left = Math.max(map.get(element) + 1, left);
            }
            max = Math.max(max, right - left + 1);
            map.put(element, right);
        }
        return max;
    }
}
