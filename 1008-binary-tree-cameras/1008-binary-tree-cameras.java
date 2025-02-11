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
    public static enum State{
        COVERED, CAMERA, NEED;
    }
    int camera = 0;
    public State dfs(TreeNode root){
        if(root == null)return State.COVERED;
        State l = dfs(root.left);
        State r = dfs(root.right);
        if(l == State.NEED || r == State.NEED){
            camera++;
            return State.CAMERA;
        }
        if(l == State.COVERED && r == State.COVERED){
            return State.NEED;
        }
        return State.COVERED;
    }
    public int minCameraCover(TreeNode root) {
        State ans = dfs(root);
        if(ans == State.NEED)camera++;
        return camera;
    }
}