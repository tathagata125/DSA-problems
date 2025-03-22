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
    TreeNode floor(TreeNode root){
        TreeNode ans = root.left;
        while(ans.right != null && ans.right != root){
            ans=ans.right;
        }
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        while(root != null){
            if(root.left == null){
                preorder.add(root.val);
                inorder.add(root.val);
                root=root.right;
                continue;
            }
            TreeNode node = floor(root);
            if(node.right == null){
                preorder.add(root.val);
                node.right = root;
                root=root.left;
            }
            else{
                inorder.add(root.val);
                node.right = null;
                root= root.right;
            }
        }
        return inorder;
    }
}