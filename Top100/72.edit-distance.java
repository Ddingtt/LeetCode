
/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    //有点类似于LCS问题，所以我们很容易想到通过动态规划来求解这个问题
    //我们首先思考一下递归过程：我们通过两个指针i和j分别指向word1和word2。
    //我们定义函数f(i,j)表示word1[:i]转换为word2[:j]需要的最少步骤
    // Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
    //     f(i, j) = f(i - 1, j - 1)
    // Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
    //     f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
    //         f(i, j - 1) represents insert operation
    //         f(i - 1, j) represents delete operation
    //         f(i - 1, j - 1) represents replace operation
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int [][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

