package LeetCode;

/**
 * @author chuYun
 * @description: 11. 盛最多的雨水
 * @date 2025/3/8 16:48
 */
public class Demo11 {


    public static void main(String[] args) {

        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Demo11().maxArea(nums));

    }


    /**
     *
     * 分析：
     *  面积 ： (right-left) * (min(nums[left], nums[right])) --决定因素，底部长度，短板
     *  若短板向内移动一格，底部变小，是不利于面积变大的，若这时候，高度变大的话，则面积可能变大，也可能变小，
     *     故，向内移动短板，查看min(nums[left], nums[right]) ，
     *     若变大，则计算面积，查看面积是否需要更新
     *     若不变或者变小，则继续移动
     *   时间0(n)
     *
     * @return res
     *
     */
    public int maxArea(int[] height) {

        int left = 0, right = height.length-1;
        int res = 0;

        while(left < right){
            if(height[left] < height[right]){
                res = Math.max(res, (right-left) * (Math.min(height[left], height[right])));
                left++;
            }else {
                res = Math.max(res, (right-left) * (Math.min(height[left], height[right])));
                right--;
            }
        }

        return res;
    }
}
