package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author chuYun
 * @description: 49. 字母异位词分组
 * @date 2025/3/6 21:15
 */
public class Demo49 {

    /**
     * 分析：
     * 1. 如何判断是否为字母异位词，将单词中的字母排序后则完全相同
     * 2. 如何将字母异位词分组，使用HashMap，key为排序后的单词，value为字母异位词的集合
     * 3. 如何将字母异位词的集合放入结果集中，使用List<List<String>>，将HashMap中的value集合放入结果集中
     *  时间O(nmlogm)
     */


    public static void main(String[] args) {

      String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
      System.out.println(new Demo49().groupAnagrams(strs));


    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String string : strs){
            //排序--将String转换为char数组，然后使用Arrays.sort()方法进行排序
            //一个单词的数组
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            //将排序后的char数组转换为String
//            String str = new String(chars);
            String str = String.valueOf(chars);
            //将排序后的String作为key，将原始的单词作为value，放入HashMap中
            if(map.containsKey(str)){
                //若存在，将其加入map中
                map.get(str).add(string);
            }else{
                //若不存在，则构建map
                //构建链标
                ArrayList<String> list = new ArrayList<>();
                list.add(string);
                map.put(str, list);
            }
        }
        //获得返回	values()返回 hashMap 中存在的所有 value 值。
        return new ArrayList<>(map.values());

    }
}
