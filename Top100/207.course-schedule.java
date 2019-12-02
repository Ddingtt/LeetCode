import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     if (prerequisites == null || prerequisites.length == 0) {
    //         return false;
    //     }
    //     if (prerequisites.length == 1) {
    //         return true;
    //     }
        
    //     for (int i = 0; i < prerequisites.length; i++) {
    //         int[] temp = prerequisites[i];
    //         exchange(temp);
    //         for (int j = 0; j < prerequisites[i].length; j++) {
    //             if (prerequisites[i][j] != temp[j]) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // private void exchange(int[] temp) {
    //     int tmp = temp[0];
    //     temp[0] = temp[1];
    //     temp[1] = tmp;
        int[] pathin = new int[numCourses];//每个数字的入度量
 
        Map<Integer,List<Integer>> map = new HashMap<>();
 
        //遍历prerequisites数组，得到每个数字的入度数，和每个数字的后继集合
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][1])){//当前数字还没有在map里存储
                //将当前数字和它的后继存入map中
                List<Integer> temp = new ArrayList();
                temp.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],temp);
            }else{//已经有过当前数字
                //更新map里的后继
                List<Integer> temp = map.get(prerequisites[i][1]);
                temp.add(prerequisites[i][0]);
            }
            //记录后继数字的pathin
            pathin[prerequisites[i][0]]++;
        }
 
        List<Integer> result = new ArrayList<>();
 
        //找出入度数为0的数字，保存到集合中
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (pathin[j] == 0){//如果入度数为0 对应的map里的后继集合中的所有数字的pahtin--
                    result.add(j);//让入度为0的数字进入集合
                    pathin[j] = -1;//标记为已经查找过了
                    List<Integer> temp = map.get(j);
                    for (int k = 0; temp!=null && k < temp.size(); k++) {
                        pathin[temp.get(k)]--;
                    }
                }
            }
 
        }
        
        return result.size()==numCourses;
    }
}
// @lc code=end

