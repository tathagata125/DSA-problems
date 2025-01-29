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
    int max = 0;
    int traverse(TreeNode root){
        if(root == null)return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        if(max < (left + right ))max = left+right;
        return Math.max(right,left)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }
}