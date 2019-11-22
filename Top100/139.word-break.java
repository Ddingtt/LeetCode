import java.util.List;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();

        boolean[] flags = new boolean[len + 1];
        flags[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (flags[j] == true && wordDict.contains(s.substring(j,i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[len];
    }
}
// @lc code=end

