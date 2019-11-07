import java.util.Stack;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        //栈的思想
        int ans = 0;
        int n = s.length();
        Stack st = new Stack();
        //合法串的开头索引值
        int index = 0;
        //开始遍历
        for (int i = 0; i < n ; i++) {
            //如果是（，入栈
            if (s.charAt(i) == '(') st.push(i);
            //如果是）
            //如果栈为空
            else if (st.size() == 0){
                //索引值向后移动一位，因为）没法配对
                index = i + 1;
                continue;
            }else {
                //如果栈不为空
                //弹出栈顶元素（，配一对括号
                st.pop();
                //此时如果栈为空，更新答案为此时的i值减去索引的值
                if (st.empty()){
                    ans = Math.max(ans,i - index + 1);
                }else {
                    //此时如果栈不为空，更新答案为此时的i值减去栈顶高度
                    ans = Math.max(ans,i - (int)st.peek());
                }
            }
        }
        
        
        return ans;
    }
}
// @lc code=end

