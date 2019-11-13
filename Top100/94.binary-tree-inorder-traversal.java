import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import javafx.scene.control.TabPane.TabClosingPolicy;


/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    //非递归中序遍历!!!
    //在【栈非空 或 head非空】时，重复执行下述操作：
    //如果head非空，把它压入栈中，并让head指向它的左孩子。
    //如果head为空，弹出栈顶节点，用head保存该节点，并打印该节点的值，并让head指向它的右孩子。
    public List<Integer> inorderTraversal(TreeNode root) {
        // method 1: iteration
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur!=null || !stack.isEmpty()) {
            while (cur!=null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;

        // // method 2: recursion
        // List<Integer> res = new ArrayList<>();
        // helper(root, res);
        // return res;
    }
    //helper function for method 1
    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
           }
       }
    }
}
// @lc code=end

