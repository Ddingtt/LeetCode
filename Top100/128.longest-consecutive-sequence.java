import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    //不好理解
    //首先O(n)限制了我们不可以先排序后遍历的传统做法
    //其次，使用hashmap数据结构，key是值，value是所在的最大长度
    //然后getOrDefault表示如果key值存在，取其value，否则设为0
    //不理解的地方：i-left和i+right都变化了之后，那中间的值怎么办？？？
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.getOrDefault(i, 0) == 0) {
                int left = map.getOrDefault(i-1, 0);
                int right = map.getOrDefault(i+1, 0);
                map.put(i, left + right + 1);
                if (left != 0) {
                    map.put(i-left, left + right + 1);
                }
                if (right != 0) {
                    map.put(i+right, left + right + 1);
                }
                max = max > (left + right + 1)? max : left + right + 1;
            }
        }
        return max;
    }
}
// @lc code=end

