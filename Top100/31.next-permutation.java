/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int get_small = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                get_small = i;
                break;
            }
        }

        if (get_small == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int get_large = -1;
        for (int i = nums.length - 1; i > get_small; i--) {
            if (nums[i] > nums[get_small]) {
                get_large = i;
                break;
            }
        }
        swap(nums, get_small, get_large);
        reverse(nums, get_small + 1, nums.length - 1);
        return;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i++] = nums[j];
        nums[j--] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
// @lc code=end

