import java.util.Stack;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || 0 == matrix.length){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] p = new int[m][n];
        int maxS = 0;

        for (int i = 0; i < m; i++) {
            for (int j = n-1; j >= 0; j--) {
                if((n-1)==j){
                    p[i][j] = 0 == (matrix[i][j] - '0') ? 0 : 1;
                }else {
                    p[i][j] = 0 == (matrix[i][j] - '0') ? 0 : (1 + p[i][j+1]);
                }
            }
        }
        for(int j = 0; j < n; j++) {
            Stack<Integer> s = new Stack<>();
            for(int i = 0; i < m; i++) {
                if(s.isEmpty() || p[i][j] >= p[s.peek()][j]) {
                    s.push(i);
                    continue;
                }
 
                while(!s.isEmpty() && p[s.peek()][j] > p[i][j]) {
                    int top = s.pop();
                    maxS = Math.max(maxS, ((s.isEmpty() ? i : i-s.peek()-1)) * p[top][j]);
                }
                s.push(i);
            }
            while(!s.isEmpty() && p[s.peek()][j] > 0) {
                int top = s.pop();
                maxS = Math.max(maxS, (s.isEmpty() ? m : m-s.peek()-1) * p[top][j]);
            }
        }
        return maxS;
    }
}
// @lc code=end

