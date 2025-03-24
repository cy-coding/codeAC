package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author chuYun
 * @description: 3.无重复字符的最长子串
 * @date 2025/3/9 15:35
 */
public class Demo3 {

    public static void main(String[] args) {

        String string = "abcabcbb";
        System.out.println(new Demo3().lengthOfLongestSubstring(string));

    }

    /**
     * 分析：
     * 1.不含有重复字符---可以将读过的字符放入HashMap中，以判断是否存在
     * 算法思路：滑动窗口----不断更新窗口的边界，保证窗口内的字段是符合要求的
     * 从头开始遍历：right 不断变大
     *  判断是否重复，map中是否存在key，
     *     若重复，则需要调整窗口的左边界，使得窗口内字符串合法
     *          将left调整为重复字符的下一个位置，这样把重复字符串筛选出去
     *          特殊，有的字符不在窗口内，但是在map中，故次数left不需要更新，
     *              此时的 left必定大于不在窗口内字符的下标
     *           综合考虑，left = Math.max(left, map.get(c) + 1);
     * 将读过的过的字符放入HashMap中（right, s[right]），更新res值
     * 时间O(n)
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        char[] charArray = s.toCharArray();
        int res = 0; //最终答案
        int left = 0; //窗口左边界
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right=0; right<charArray.length; right++){
            char c = charArray[right];
            //若存在，需要更新左边界
            if(map.containsKey(c)){
                //abbac--存在再次遍历到a时，a不在窗口内，但是再map中，此时不应该更新left
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right); // 值，下标 (若已经存在，则会将值更新)
            res = Math.max(res, right-left+1);
        }

        return res;
    }
}
