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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null)return arr;
        q.add(root);
        while(q.size() > 0){
            arr.add(q.peek().val);
            int size = q.size();
            for(int i = 0 ;i < size; i++){
                TreeNode node = q.remove();
                if(node.right != null)q.add(node.right);
                if(node.left != null)q.add(node.left);
            }
        }
        return arr;
    }
}