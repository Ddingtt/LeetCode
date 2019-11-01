import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String[]> map = new HashMap<>();
        map.put(2, new String[]{"a","b","c"});
        map.put(3, new String[]{"d","e","f"});
        map.put(4, new String[]{"g","h","i"});
        map.put(5, new String[]{"j","k","l"});
        map.put(6, new String[]{"m","n","o"});
        map.put(7, new String[]{"p","q","r","s"});
        map.put(8, new String[]{"t","u","v"});
        map.put(9, new String[]{"w","x","y","z"});

        int len = digits.length();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int flag2 = Integer.parseInt(digits.substring(i, i + 1));
            String[] tmp = map.get(flag2);
            List<String> list_temp = new ArrayList<>();
            if (i != 0) {
                for (int j = 0; j < res.size(); j++) {
                    for (int k = 0; k < tmp.length; k++) {
                        String f = res.get(j) + "" + tmp[k];
                        System.out.println(f);
                        list_temp.add(f);
                    }
                }
                res = list_temp;
            }
            else {
                for (int k = 0; k < tmp.length; k++) {
                    res.add(tmp[k]);
                }
            }
        }
        return res;
    }
} 
// @lc code=end

