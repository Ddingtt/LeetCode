/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] word_char = word.toCharArray();
        Boolean res=false;
        //变化方向
        int[][] change={{0,1},
                        {1,0},
                        {0,-1},
                        {-1,0}};
        //其他特殊情况
        if (word.length()==0 || board.length==0 || board[0].length==0) return res;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                //遍历，如果遇到第一个字母，开始
                if (board[i][j]==word_char[0]){
                    res=dfs(0,i,j,board,word_char,change);
                    if (res)return res;
                }
            }
        }
        return res;
    }
    //深度优先搜索
    //parameter：子串开始位置，矩阵开始i，矩阵开始j，char型矩阵，char型字串，变化矩阵
    public boolean dfs(int wor_i,int start_i,int start_j,char[][] board,char[] word_char,int[][] change){
        //如果不相等，返回false
        if(word_char[wor_i]!=board[start_i][start_j])return false;
        //是否为最后一个并且成立
        if(wor_i==word_char.length-1){
            return true;
        }
        char a=board[start_i][start_j];
        //能到达则进行标志
        board[start_i][start_j]='#';
        for (int i = 0; i < 4; i++) {
            int index_i = start_i+change[i][0];
            int index_j = start_j+change[i][1];
            //先进行剪枝
            if (index_i>=0&&index_i<board.length&&index_j>=0&&index_j<board[0].length&&board[index_i][index_j]!='#'){
                //进行返回结果
                if (dfs(wor_i+1,index_i,index_j,board,word_char,change))return true;
            }
        }
        board[start_i][start_j]=a;
        return false;
    }
}
// @lc code=end

