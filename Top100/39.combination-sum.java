import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//先将数列按从大到小的顺序排序
        List<List<Integer>> result = new ArrayList<>();//初始化结果
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                //当目标大于头开始的值，将它加入
                cur.add(candidates[i]);
                //子问题，更新目标值为目标值减去已经算进去的值
                getResult(result, cur, candidates, target - candidates[i], i);
                //数查找玩要进行回溯！！！
                cur.remove(cur.size() - 1);
            }
        }
        else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));//目标等于0，返回0值
        }
    }
} 
// @lc code=end

