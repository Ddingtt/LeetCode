/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    //dp问题
    public int numTrees(int n) {
        //空树
        if (n == 0) {
            return 1;
        }
        //只有一个根节点的树
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n+1];
        nums[0] = 1; nums[1] = 1;

        //nums[0]和nums[1]已经讨论过了，从2开始！！！
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //分成左右子问题
                //左边j是一个子树
                //右边i-1-j也是一个子树
                nums[i] += nums[j] * nums[i-1-j];
            }
        }
        return nums[n];
    }
}
// @lc code=end

