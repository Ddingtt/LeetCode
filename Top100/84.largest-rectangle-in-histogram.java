import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    //递增栈法：寻找递增的情况直到递减，开始判断是否是max
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            //高度要有0，相当于在最后加了一个0高度，因为要考虑最后一位
            int h = (i == len? 0 : heights[i]);
            //压栈情况：为空 或者 递增
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            }
            //弹栈情况：更新最大值
            else{
                int tp = s.pop();
                //宽度 = 如果为空，就是 i 的值，如果不为空就减去栈顶索引
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                //弹栈索引只需要减一！！！！！！
                i--;
            }
        }
        return maxArea;
    }
}
// @lc code=end

