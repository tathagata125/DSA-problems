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
    int sum =0;
    int diff(TreeNode root){
        if(root == null)return 0;
        int left = root.val +  diff(root.left);
         int right = diff(root.right);
        return left + right;
    }
    public int findTilt(TreeNode root) {
        if(root == null)return 0;
       root.val =Math.abs( diff(root.left)-diff(root.right)); 
        sum += root.val;
       findTilt(root.left);
       findTilt(root.right);
       return sum;
    }
}