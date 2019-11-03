import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        //如果数组的大小小于等于1，结果就是它本身
        if (intervals.length <= 1) {
            return intervals;
        }
        //排序，这个函数没搞懂！！！
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        //声明存结果的地方，List型
        List<int[]> result = new ArrayList<>();
        //间接存量，初始化为第一个区间
        int[] newInterval = intervals[0];
        //加入到结果队列中
        result.add(newInterval);
        //开始按照区间遍历
        for (int [] interval : intervals) {
            //如果新的区间的左值小于间接存量的右值，
            //那么存在交叉区间，更新间接存量的右值
            //右值是两个区间的最大值
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            //否则更新间接存量为新的区间
            //并把它加入结果队列
            else{
                newInterval = interval;
                result.add(newInterval);
            }
        }
        //返回值不是List型，需要转换一下
        //使用List的好处是有add函数，方便操作
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

