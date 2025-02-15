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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null)return arr;
        q.add(root);
        
        while(q.size() > 0){
            List<Integer> l = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                l.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            
            arr.add(l);
        }
        Collections.reverse(arr);
        return arr;
    }
}