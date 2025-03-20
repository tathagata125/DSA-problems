/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode r = null;
    TreeNode ancestor(TreeNode root, TreeNode p , TreeNode q){
        if(p.val < root.val && q.val < root.val)ancestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val)ancestor(root.right, p , q);
        else if(p.val == root.val || q.val == root.val){
            r= root;
        }
        else{
            r= root;
        }
        return r;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ancestor(root, p , q);
    }
}