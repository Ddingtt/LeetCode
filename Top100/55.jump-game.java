/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // 特殊情况：数组长度为0或者1，结果是true
        if (nums.length <= 1) {
            return true;
        }
        // 此步骤是不需要的~
        // if(nums[0] == 0){
        //     return false;
        // }

        // 普通情况：从后向前推，最后一个数加上他的索引大于最大长度就能到达
        // 然后更新最后一个数
        // 最后遍历完成，看看更新后的last是不是第一个
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}
// @lc code=end

