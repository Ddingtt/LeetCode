import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper("", res, n, 0, 0);
        return res;
    }
    public void helper(String curr, List<String> res, int n, int left, int right) {
        if (right == n) {
            res.add(curr);
            return;
        }
        if (left < n) {
            helper(curr + "(", res, n, left + 1, right);
        }
        if (right < left) {
            helper(curr + ")", res, n, left, right + 1);
        }
    }
}
// @lc code=end
 
