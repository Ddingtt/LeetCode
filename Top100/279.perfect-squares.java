/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    static int[] arr;
    public int numSquares(int n) {
        arr = new int[n+1];//创建一个数组以保存计算出来的f(n)
		for(int i=0;i<n+1;i++)//初值为-1
			arr[i] = -1;
		return f(n);
    }
    public static int f(int n){
		if(arr[n] != -1) return arr[n];//当arr[n]已经被赋过值，便返回arr[n]。
		
		if(n==1 || n==2 || n==3) return n;
		int temp = (int) Math.sqrt(n);
		if(temp*temp == n) return 1;
		
		int min = Integer.MAX_VALUE;
		for(int i=1;i*i <= n;i++){
			min = Math.min(min, f(n-i*i)+1);
		}
		
		arr[n] = min;
		return arr[n];
	}
}

// @lc code=end

