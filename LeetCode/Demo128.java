package LeetCode;

/**
 * @author chuYun
 * @description: 128. 最长连续序列
 * @date 2025/3/7 10:42
 */


import java.util.HashSet;

/**
 * HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
 * HashSet 允许有 null 值。
 * HashSet 是无序的，即不会记录插入的顺序。
 * HashSet 不是线程安全的， 如果多个线程尝试同时修改 HashSet，则最终结果是不确定的。 您必须在多线程访问时显式同步对 HashSet 的并发访问。
 * HashSet 实现了 Set 接口。
 */

public class Demo128 {




    public static void main(String[] args) {
        int[] nums =  new int[]{100,4,200,1,3,2};
        System.out.println(new Demo128().longestConsecutive(nums));

    }

    /**
     * 分析:
     *  1.找出数字连续的最长序列-->需要设定一个length来不断个更新，取最大值
     *  2.采用HashSet来存储，不存在重复元素，然后遍历HashSet
     *      要从每个连续段最小的值开始算
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums){
        int length = 0;
        HashSet<Integer> hashSet = new HashSet<>();

        // 构建HashSet
        for(int num : nums){
            hashSet.add(num);
        }

        // 遍历HashSet

        for(int x : hashSet){

            // 找到连续段最小的值
            if (hashSet.contains(x-1)){
                continue;
            }
            int y = x + 1;
            while(hashSet.contains(y)){
                y++;
            }
            // 循环结束，y-1集合中, 序列长度为 y - x (y-1-x +1)
            length = Math.max(length, y - x);
        }
        return length;
    }
}
