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
    List<Integer> node ;
    void Traversal(TreeNode root){
        if(root == null)return;
        if(root.left != null)Traversal(root.left);
        node.add(root.val);
        if(root.right != null)Traversal(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        node = new ArrayList<>();
        Traversal(root);
        return node;
    }
}