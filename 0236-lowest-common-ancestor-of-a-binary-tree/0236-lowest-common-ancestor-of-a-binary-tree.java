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
    TreeNode node;
    TreeNode dfs(TreeNode root, TreeNode p , TreeNode q){
        if(root == null)return null;
        
        TreeNode left = dfs(root.left,p,q);
        TreeNode right = dfs(root.right, p,q);
        if(left != null && right != null){
            node=root;
            return node;
        }
        else if(left != null ){
            if(root == p)return p;
            if(root == q)return q;
            return left;
        }
        else if(right != null){
            if(root == p)return p;
            if(root == q)return q;
            return right;
        }
        if(root == p)return p;
        if(root == q)return q;
        
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        node = new TreeNode();
        
        return dfs(root, p, q);
    }
}