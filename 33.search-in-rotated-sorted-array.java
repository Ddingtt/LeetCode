/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > nums[left]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    if (target > nums[left]) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            } else {
                if (target > nums[mid]) {
                    if (target < nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

