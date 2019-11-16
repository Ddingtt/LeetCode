/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    //***不用排序，只是转成链表
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        //如果右子树为空左子树不为空
        if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        }
        //如果右子树不为空左子树为空对右子树进行递归
        if (root.left == null && root.right != null) {
            flatten(root.right);
            return;
        }
        //如果左右子树都不为空左右子树分别递归 递归完把左子树加进到右子树中
        if (root.left != null && root.right != null) {
            flatten(root.left);
            flatten(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
            root.left = null;
        }
    }
}
// @lc code=end

