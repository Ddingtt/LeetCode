import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midTraverse(root, list);
        if (list.size() == 0) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> midTraverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            midTraverse(root.left, list);
            list.add(root.val);
            midTraverse(root.right, list);
        }
        return list;
    }
}
// @lc code=end

