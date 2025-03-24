package LeetCode;

import java.util.*;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/13 20:50
 */
public class Demo56 {
    public static void main(String[] args){

        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(new Demo56().merge(nums)));

    }

    /**
     *排序+哈希
     * 每个区间，start作为key，end作为value构建哈希表
     * 将所有start排序，然后开始遍历，比较endi 和starti+1
     *  end_i >= start_i+1 则需要进行区间合并，将end_i = end_i+1
     *  end_i < start_i+1 不需要进行合并，start_i end_i 为一个区间
     * 时间O(nlogn)
     *[[1,3],
     * [2,6],
     * [8,10],
     * [15,18]]
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // 可以合并
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]); // 更新右端点最大值
            } else { // 不相交，无法合并
                ans.add(p); // 新的合并区间
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
