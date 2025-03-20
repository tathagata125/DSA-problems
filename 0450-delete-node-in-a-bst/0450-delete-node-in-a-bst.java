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
    int floor(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val)root.right = deleteNode(root.right, key);
        else if(key == root.val){
            if(root.left == null)return root.right;
            else if(root.right == null)return root.left;
            else{
                int replace = floor(root.left);
                root.val = replace;
                root.left = deleteNode(root.left,replace);
            }
        }
        return root; 
    }
}