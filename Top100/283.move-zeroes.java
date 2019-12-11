/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[insertPos] = num;
                insertPos++;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}
// @lc code=end

