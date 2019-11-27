import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len/2];
    }
}
// @lc code=end

