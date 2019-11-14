import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
        {
            return true;
        }
        else {
            return isSymmetric(root.left,root.right);
        }
    }
    private boolean isSymmetric(TreeNode p,TreeNode q)
    {
        if(p==null&&q==null)
        {
            return true;
        }
        if (p==null||q==null)
        {
            return false;
        }
        return  p.val==q.val&&isSymmetric(p.right,q.left)&&isSymmetric(p.left,q.right);
    }
}
// @lc code=end

