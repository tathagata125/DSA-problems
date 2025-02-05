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
    
    int dfs(TreeNode root, long s , int targetSum,HashMap<Long,Integer>hash){
        if(root == null)return 0;
        
        s += root.val;
        int count = hash.getOrDefault(s-targetSum,0);
        hash.put(s,hash.getOrDefault(s,0)+1);
        
         count+= dfs(root.left, s,targetSum,hash);
         count +=dfs(root.right, s, targetSum,hash);
         hash.put(s,hash.getOrDefault(s,0)-1);
         return count;

    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> hash = new HashMap<>();
        hash.put(0L, 1);
       return dfs(root,0,targetSum,hash);
       
       
    }
}