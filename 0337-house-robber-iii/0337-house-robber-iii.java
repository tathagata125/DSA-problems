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
        int no;
        int yes;
        Pair(int yes, int no){
            this.yes = yes;
            this.no = no;
        }
        Pair(){};
    }
    Pair dfs(TreeNode root){
        if(root == null)return new Pair(0,0);
        Pair p = new Pair();
        Pair l = dfs(root.left);
        Pair r = dfs(root.right);
        p.yes = root.val + l.no + r.no;
        p.no = Math.max(l.yes, l.no) + Math.max(r.yes, r.no);
        return p;
    }
    public int rob(TreeNode root) {
        Pair p = dfs(root);
        return Math.max(p.yes,p.no);
    }
}