import java.util.Arrays;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        // for (int i = 0; i < nums.length / 2; i++) {
        //     int temp = nums[i];
        //     nums[i] = nums[nums.length - 1 - i];
        //     nums[nums.length - 1 - i] = temp;
        // }
        return nums[nums.length - k];
    }
}
// @lc code=end

