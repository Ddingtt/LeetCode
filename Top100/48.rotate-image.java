/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    // 因为不能够再申请内存，所以需要在原来的基础上转换
    // 则需要一个中间变量temp作为交换媒介
    // 然后需要找到转换规则
    // 我们发现：
    // [0][0] --> [0][2]
    // [0][2] --> [2][2]
    // [2][2] --> [2][0]
    // [2][0] --> [0][0]

    // [0][1] --> [1][1]
    // [1][1] --> [2][1]
    // [2][1] --> [1][0]
    // [1][0] --> [0][1]

    // 使用归纳法，我们可以发现规律：[x][y] --> [y][n - 1 - x]
    // 分解为[x][y] --> [y][x] --> [y][n - 1 - x]
    // 其实就是前一次对角线反转，后一次中线反转

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //首先，沿着对角线进行变换 : ij->ji
        for(int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //然后，沿着中线进行翻转 : i->i,j->n-1-j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
// @lc code=end

