import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    //滑动窗口算法：https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-tong-yong-si-xiang-by-/
    public String minWindow(String s, String t) {
        //先建立一个哈希表，
        //标明t中每一个字母出现次数
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        //计数
        int count = t.length();
        //l和r都指定为0，即初始位置是最左边
        int left = 0, right = 0;
        //初始化参数
        int min = Integer.MAX_VALUE, minLeft = 0, minRight = 0;
        //当右指针还小于s的时候，表明可以继续执行
        while(right < s.length()) {
            char c = s.charAt(right);
            //如果在s中找到了t中的字母
            if(map.containsKey(c)) {
                //value-1
                map.put(c, map.get(c) - 1);
                //计数-1
                if(map.get(c) >= 0) { 
                    count--;
                }
            }
            //遍历完全
            while(count == 0) {
                //更新最小长度
                if(right - left < min) {
                    minLeft = left;
                    minRight = right;
                    min = minRight - minLeft;
                }
                //计数+1
                char c2 = s.charAt(left);
                if(map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if(map.get(c2) > 0) {
                        count ++;
                    }
                }
                //左指针右移
                left++;
            }
            //右指针右移
            right++;
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(minLeft, minRight + 1);
    }
}
// @lc code=end

