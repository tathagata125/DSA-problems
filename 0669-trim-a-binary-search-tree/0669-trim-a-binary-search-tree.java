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
    public TreeNode trimBST(TreeNode root, int l, int h) {
        if(root == null)return null;
        if(root.val > h)return trimBST(root.left,l, h);
        else if(root.val < l)return trimBST(root.right,l, h);
        root.left = trimBST(root.left,l,h);
        root.right = trimBST(root.right, l, h);
        return root;
    }
}