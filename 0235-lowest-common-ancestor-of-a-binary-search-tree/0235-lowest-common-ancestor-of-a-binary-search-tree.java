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
    TreeNode search(TreeNode root, TreeNode p, TreeNode q){
        TreeNode node = root;
        if(p.val < root.val && q.val < root.val ){
            node = search(root.left,p,q);
        }
        else if(p.val > root.val && q.val > root.val){
            node=search(root.right,p,q);
        }
        return node;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = search(root, p, q);
        return node;
    }
}