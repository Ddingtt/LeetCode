import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //创建一个结果
        List<List<String>> result = new ArrayList<>();
        //如果小于1直接返回
        if (strs.length < 1) {
            return result;
        }
        //新建hashmap，key是String，value是一个List
        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        //中间变量
        String tmp = "";
        //遍历String数组
        for (int i = 0; i < strs.length; i++) {
            tmp = strs[i];
            //转char
            char[] item1=tmp.toCharArray();
            //按字母表排序，作为一个标准key
            Arrays.sort(item1);
            tmp = new String(item1);
            //如果map中有这个key了
            if (ans.containsKey(tmp)) {
                //按这个key找到value，再add新遍历的这个
                ans.get(tmp).add(strs[i]);
            }else{//如果没有这个key
                List<String> ans1 = new ArrayList<String>();
                ans1.add(strs[i]);
                //那就把这个key和对应的value加入进去
                ans.put(tmp, ans1);
            }
        }
        //遍历map的value，将结果添加到result后返回
        for (List<String> value : ans.values()) {
            result.add(value);
        }
        return result;
    }
}
// @lc code=end

