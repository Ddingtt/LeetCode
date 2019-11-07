/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    //难点在于不可以借助额外内存
    //所以必须在原来的数组进行操作
    public int firstMissingPositive(int[] nums) {
        //找到第一个缺失的正整数
        int n = nums.length;
        //不做处理的情况：
        //0，负数，大于数组长度的数，相等的交互数据（为了避免死循环）
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                //将数x交换到索引x-1位置
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        //遍历新数组，找到第一个不符合规律的数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //如果没找到，那证明现在数列中的数都正确
        //则返回数组+1
        return n + 1;
    }
}
// @lc code=end

