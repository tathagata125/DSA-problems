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
    int xParent = -1, xDepth=-1, yParent = -1, yDepth= -1;
    void dfs(TreeNode root,int parent, int x , int y , int i){
        if(root == null)return;
        if(root.val == x){
            xParent = parent;
            xDepth = i;
        }
        if(root.val == y){
            yParent = parent;
            yDepth = i;
        }
        dfs(root.left,root.val,x,y,i+1 );
        dfs(root.right,root.val,x,y,i+1);
        
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        System.out.println(xParent);
        System.out.println(yParent);
        System.out.println(xDepth);
        System.out.println(yDepth);
        dfs(root,root.val,x,y,0);
        return (xParent != yParent) && (xDepth == yDepth);
    }
}