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
    void dfs(TreeNode root , int k){
        if(root == null)return;
        dfs(root.left, k+1 );
        dfs(root.right, k+1);
        max = Math.max(k, max);
    }
    int find(TreeNode root, int start){
        if(root == null)return -1;
        if(root.val == start){
            dfs(root,0);
            return 1;
        }
        int left = find(root.left, start);
        if(left >= 0){
            dfs(root.right , left+1);
            max = Math.max(left,max);
            return left + 1;
        }
        int right = find(root.right, start);
        if(right >= 0){
            dfs(root.left, right + 1);
            max= Math.max(right,max);
            return right + 1;
        }
        return -1;
    }
    public int amountOfTime(TreeNode root, int start) {
        find(root, start);
        return max;
    }
}