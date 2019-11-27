/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        if (nums.length == 1)return nums[0];
        if (nums.length == 2) return nums[0]>nums[1] ? nums[0]:nums[1];
        
        int[] array = new int[nums.length];//保存每个位置的可以抢到的最大的数
        
        for (int i = 0; i < nums.length; i++){
            if (i == 0 ) array[0] = nums[0];
            else if (i == 1 ) array[1] = Math.max(nums[0],nums[1]);
            else array[i] = Math.max(array[i-1], (array[i-2]+nums[i]));
        }
        return array[nums.length-1];
    }
}
// @lc code=end

