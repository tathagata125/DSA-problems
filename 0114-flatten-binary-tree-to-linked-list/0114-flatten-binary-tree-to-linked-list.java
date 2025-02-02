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
    
    class Pair{
        TreeNode head, tail;
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    Pair traverse(TreeNode root){
        if(root == null)return new Pair(null,null);
        if(root.left == null && root.right == null)return new Pair(root,root);
        if(root.left == null){
            Pair r = traverse(root.right);
            root.right = r.head;
            return new Pair(root,r.tail);
        }
        if(root.right == null){
            Pair l = traverse(root.left);
            root.right = l.head;
            root.left =null;
            return new Pair(root,l.tail);
        }
        Pair l = traverse(root.left);
        Pair r = traverse(root.right);
        root.left = null;
        root.right = l.head;
        l.tail.right = r.head;
       
        return new Pair(root,r.tail);
    }
    public void flatten(TreeNode root) {
        traverse(root);
    }
}