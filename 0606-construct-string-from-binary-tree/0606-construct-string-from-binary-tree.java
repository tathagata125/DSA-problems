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
    void dfs(TreeNode root, StringBuilder str){
        if(root == null)return ;
        if(str.length() == 0)str.append(""+root.val);
        else
            str.append("(").append(""+root.val);
        if(root.left != null && root.right != null){
            dfs(root.left,str);
            dfs(root.right, str);
        }
        else if(root.left == null && root.right != null){
            str.append("()");
            dfs(root.right,str);
        }
        else if(root.left != null && root.right == null ){
            dfs(root.left,str);
        }
        str.append(")");
    }
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs(root,str);
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }
}