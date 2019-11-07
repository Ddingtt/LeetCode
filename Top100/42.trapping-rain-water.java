/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int result = 0;
        int maxValue = -1;
        int maxAddr = 0;
        //取最大数值和下标
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= maxValue) {
                maxValue = height[i];
                maxAddr = i;
            }
        }
        //左半部分
        for (int left = 0; left < maxAddr; left++) {
            //当前left位置的下一位开始
            for (int i = left + 1; i <= maxAddr; i++) {
                //如果比left小，表示可以接水
                if (height[i] < height[left]) {
                    //水量为1 * 高度差
                    result += height[left] - height[i];
                }
                else{
                    //比left大，更新left的值
                    left = i;
                }
            }
        }
        //右半部分
        for (int right = height.length - 1; right > maxAddr; right--) {
            for (int i = right - 1; i >= maxAddr; i--) {
                if (height[i] < height[right]) {
                    result += height[right] - height[i];
                }
                else{
                    right = i;
                }
            }
        }
        return result;
    }
}
// @lc code=end

