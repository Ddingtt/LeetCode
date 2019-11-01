import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        recursion(resultList, result, nums);
        return resultList;
    }

    public void recursion(List<List<Integer>> resultList, List<Integer> result, int[] nums){
        //如果result的大小等于数组大小，表示本趟递归已经完成，加入到返回值中
        if(result.size() == nums.length){
            resultList.add(new ArrayList<>(result));
        }else{//否则继续遍历
            for (int i = 0; i < nums.length; i++) {
                //如果遇到重复的数字，无操作，继续进行for循环
                if(result.contains(nums[i])){
                    continue;
                }else{//如果不是重复的，加入到结果队列中
                    result.add(nums[i]);
                    //用更新的resultList和更新的result，继续按顺序遍历下去
                    recursion(resultList, result, nums);
                    //回溯！！！查找下一种情况
                    result.remove(result.size() - 1);
                }
            }
        }
    }
}
// @lc code=end

