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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> arr = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null)return arr;
        q.add(root);
        
        while(q.size() > 0){
            Double count = 0.0;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                count += node.val;
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            count /= size;
            arr.add(count);
        }
        return arr;
    }
}