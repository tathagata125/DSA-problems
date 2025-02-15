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
 class Pair{
    int level ,  val;
 }
class Solution {
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null)return 0;
        q.add(root);
        Pair max = new Pair();
        max.level = 0;
        max.val = Integer.MIN_VALUE;
        int j = 1;
        while(q.size() > 0){
            int count = 0;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                count += node.val;
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            if(count > max.val){
                max.val = count;
                max.level = j;
                j++;
            }
            else{
                j++;
            }
            
        }
        return max.level;
    }
}