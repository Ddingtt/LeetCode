/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    //动态规划
    //假设当前要求的是point(i,j)点，
    //那么它的值就应该是从左上角到它上面那个点point(i-1,j)的路径和，
    //与从左上角到它左边那个点point(i,j-1)的路径和，
    //两者中的最小值加上它自身的值。
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        //特别地，第一行的最小路径和只能从左边向右移动，
        //所以grid[0][j] = grid[0][j] + grid[0][j-1]；
        //第一列的最小路径和只能从上到下移动，
        //所以grid[j][0] = grid[j][0] + grid[j-1][0].
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //如果只有一行
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j-1];
                }
                //如果只有一列
                else if (i != 0 && j == 0){
                    grid[i][j] += grid[i - 1][j];
                }
                //如果是普通位置
                else if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]); 
                }
            }
        }
        return grid[row-1][col-1];
    }
}
// @lc code=end

