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
    int value = 0;
    void revInorder(TreeNode root){
        if(root == null)return;
        
        revInorder(root.right);
        value += root.val;
        root.val = value;
        revInorder(root.left);
        
    }
    public TreeNode convertBST(TreeNode root) {
        revInorder(root);
        return root;
    }
}