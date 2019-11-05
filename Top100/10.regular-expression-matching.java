/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        // //dp[sidx][pidx]表示在长为sidx的s的子串与长为pidx的p的子串的匹配情况
        // boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // dp[0][0] = true;
        // //当s为空串的时候，p只有一种情况能够成立，即“a*b*c*……”
        // //奇数字符全为false，偶数每隔两个字符检查是否是'*'，若是则其是否成立取决于上一个偶数项的情况
        // for (int pidx = 2; pidx <= p.length(); pidx += 2) {
        //     if (p.charAt(pidx - 1) == '*') {
        //         dp[0][pidx] = dp[0][pidx - 2];
        //     }
        // }

        // //dp[sidx][pidx]对应s和p的下标为sidx-1和pidx-1
        // for (int sidx = 1; sidx <= s.length(); sidx++) {
        //     for (int pidx = 1; pidx <= p.length(); pidx++) {
        //         //当前元素匹配时，dp[sidx][pidx]取决于dp[sidx - 1][pidx - 1]
        //         if (s.charAt(sidx - 1) == p.charAt(pidx - 1) || p.charAt(pidx - 1) == '.'){
        //             dp[sidx][pidx] = dp[sidx - 1][pidx - 1];
        //         }
        //         //p当前元素为'*'时
        //         else if(p.charAt(pidx - 1) == '*'){
        //             //如果'*'的元素不匹配，则只可能是元素出现0次的情况，dp[sidx][pidx]取决于dp[sidx][pidx - 2]
        //             if (p.charAt(pidx - 2) != s.charAt(sidx - 2) && p.charAt(pidx - 2) != '.'){
        //                 dp[sidx][pidx] = dp[sidx][pidx - 2];
        //             }
        //             //如果'*'的元素匹配，可能有两种情况：元素出现0次（取决于dp[sidx][pidx - 2]）、出现多次（dp[sidx - 1][pidx]，包含出现1次（取决于dp[sidx][pidx - 1]））
        //             else{
        //                 dp[sidx][pidx] = (dp[sidx][pidx - 2] || dp[sidx - 1][pidx]);
        //             }
        //         }
        //     }
        // }
        // return dp[s.length()][p.length()];

        //注意if括号中的是判断p是否为空，而不是s是否为空，，因为如果s为空，p可以不为空，因为*前面那个字符可以是出现0次
        if(p.isEmpty()){
            return s.isEmpty();
        }
        //判断第一个字符是否能匹配上，做一个标记
        boolean first_match = (s.length() > 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //如果p的长度大于等于2，并且p的第二个字符是*。有两种情况：1.第一个字符匹配不上，s不动P向后移动2个位置，继续比较
        //第一个字符能匹配上(first_match),后移动1个位置,p不动，继续比较
        //否则，如果p的第二个字符不是*,是普通字符或者是.,先判断第一个字符是否能匹配上，再将s向后移1位，p向后移1位，继续比较
        if (p.length() > 1 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1),p));
        }else{
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
// @lc code=end

