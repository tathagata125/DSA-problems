/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean inorder(TreeNode root, long low , long right){
        if(root == null)return true;
        if(root.val <= low || root.val >= right)return false;
        return inorder(root.left, low, root.val) && inorder(root.right, root.val, right);

    }
    public boolean isValidBST(TreeNode root) {
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}