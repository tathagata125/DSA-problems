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
    int xLevel = -1, yLevel = -1, xParent = -1, yParent = -1;
    void dfs(TreeNode root, int x , int parent, int y, int level){
        if(root == null)return;
        if(root.val == x){
            xLevel=level;
            xParent = parent;
        }
        if(root.val == y){
            yLevel=level;
            yParent = parent;
        }
        dfs(root.left,x,root.val,y,level+1);
        dfs(root.right,x,root.val,y,level+1);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, -1, y, 0);
        System.out.println(xLevel);
        System.out.println(yLevel);
        System.out.println(xParent);
        System.out.println(yParent);
        return (xLevel == yLevel && xParent != yParent);
    }
}