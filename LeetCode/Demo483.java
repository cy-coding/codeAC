package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author chuYun
 * @description: 438.找到字符串中所有的字母异位词
 * @date 2025/3/9 16:39
 */
public class Demo483 {

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new Demo483().findAnagrams(s,p));

    }


    /**
     * 分析：
     * 滑动窗口法：窗口合法内容为p的异位词，如何判断是否合法--
     *时间O(n)
     * @param s
     * @param p
     * @return
     */

    public List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;

        int left=0;
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();

        //判定条件就是两种出现次数相同，若发现窗口中某个字母的出现此处大于pCount说明窗口中存在不符合的字母，这样就修正left
        //统计p字符中所有字母出现的次数
        int[] pCount = new int[26];
        //统计滑动窗口中字母出现的次数
        int[] sCount = new int[26];

        for(char pc : p1){
            pCount[pc-'a']++;
        }


        for(int right = 0; right < s1.length; right++){

            char cur = s1[right];
            sCount[cur-'a']++;
            //对应的频次可以小，但不能大，如果大了说明出现新的字母或者字母频次超了
            while(sCount[cur-'a'] > pCount[cur-'a'] ){
                char curleft = s1[left];
                //对应左边界字母去除，频次减一
                sCount[curleft-'a']--;
                left++;
            }

            if(right - left + 1 == p1.length){
                //窗口内容满足条件了
                res.add(left);
            }
        }
        return res;
    }

}
