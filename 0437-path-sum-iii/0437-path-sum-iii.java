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
    int sum ;
    void dfs(TreeNode root, long s , int targetSum){
        if(root == null)return;
        if(s+root.val == targetSum)sum++;
         dfs(root.left, s+root.val,targetSum);
         dfs(root.right, s+root.val, targetSum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)return 0;
       
       dfs(root,0,targetSum);
       pathSum(root.left,targetSum);
       pathSum(root.right,targetSum);
       return sum;
    }
}