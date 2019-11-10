import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    //dp问题
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //排序去重
        Arrays.sort(nums);
        //初始状态：空reslist，list，整个nums，从0开始
        backtracking(resList, list, nums, 0);
        return resList;
    }
    public void backtracking(List<List<Integer>> resList, List<Integer> list, int[] nums, int start) {
        //第一次循环加入了[]空
        resList.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(resList, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

