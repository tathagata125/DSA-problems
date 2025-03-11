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
    int res = 0;
    int g ;
    void inorder(TreeNode root, int k ){
        if(root == null || g== 0){
            return;
        }
        inorder(root.left,k);
        g--;
        if(g== 0){
            res=root.val;
            return;
        }
        inorder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        g=k;
        inorder(root, k);
        return res;
    }
}