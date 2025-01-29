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
    List<Integer>node;
    void traverse(TreeNode root){
        if(root == null)return;
        node.add(root.val);
        if(root.left != null)traverse(root.left);
        if(root.right != null)traverse(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        node = new ArrayList<>();
        traverse(root);
        return node;
    }
}