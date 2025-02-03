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
    int max=Integer.MIN_VALUE;
    int  dfs(TreeNode root){
        if(root == null)return 0;
        if(root.val > max)max = root.val;
        int left = dfs(root.left);
        if(root.val+left > max)max = root.val + left;;
        int right = dfs(root.right);
        if(root.val + right > max)max = root.val+right;
        if(root.val + right +left > max)max =root.val + right + left;

        return root.val+Math.max(0,Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
         if(root == null)return 0;
       
       dfs(root);
       maxPathSum(root.left);
       maxPathSum(root.right);
       return max ;
    }
}