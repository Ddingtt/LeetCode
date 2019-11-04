/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    //dp问题：
    //1. 递归不在乎子问题重复
    //2. 递归在乎子问题重复
    //3. 动态规划
    public int uniquePaths(int m, int n) {
        //存结果的二维数组
        int[][] dp = new int[m + 1][n + 1];
        //矩阵如果是1*1的结果为1
        dp[1][1] = 1;
        //第一行的都是1，因为只有一种走法
        for (int j = 2; j <= n; j++) dp[1][j] = dp[1][j - 1]; //第一行
        //第一列的都是1，因为只有一种走法
        for (int i = 2; i <= m; i++) dp[i][1] = dp[i - 1][1];
        //其他普通情况是左边和上边相邻的dp[][]的和
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        //所有情况填充完成，按照下标返回即可
        return dp[m][n];
    }
}
// @lc code=end

