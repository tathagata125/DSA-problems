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
    
    boolean dfs(TreeNode root, int sum, int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            if((sum + root.val) == targetSum)return true;
            else return false;
        }
        
        return dfs(root.left,sum+root.val,targetSum)|| dfs(root.right,sum+root.val,targetSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            
                return false;
            
        }
        
        
        if(dfs(root,0,targetSum))return true;
        return false;
    }
}