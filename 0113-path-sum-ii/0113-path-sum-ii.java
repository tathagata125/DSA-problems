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
    List<List<Integer>> res;
    void dfs(TreeNode root,int sum, ArrayList<Integer>output, int targetSum){
        if(root == null)return;
        if(root.left == null && root.right == null ){
            if(sum + root.val == targetSum ){
                output.add(root.val);
                res.add(new ArrayList<>(output));
                output.remove(output.size()-1);
            }
            return;
        }
        output.add(root.val);
        dfs(root.left,sum+root.val,output,targetSum);
        dfs(root.right,sum+root.val,output,targetSum);
        output.remove(output.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        ArrayList<Integer>arr = new ArrayList<>();
        dfs(root,0, arr,targetSum);
        return res;
    }
}