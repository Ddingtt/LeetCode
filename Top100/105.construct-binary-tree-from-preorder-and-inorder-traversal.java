/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    //前序遍历和中序遍历建立二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length-1);
    }
    public TreeNode build(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        //结束标记
        if (preStart > pre.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int index = 0;
        //遍历中序序列找到根节点
        //则根节点之前的都在左子树中
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == in[i]) {
                index = i;
                break;
            }
        }
        //子问题：左子树建立
        root.left = build(pre, in, preStart+1, inStart, index-1);
        //子问题：右子树建立
        root.right = build(pre, in, preStart+index-inStart+1, index+1, inEnd);
        return root;
    }
}
// @lc code=end

