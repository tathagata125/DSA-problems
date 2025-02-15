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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null)return arr;
        q.add(root);
        List<Integer> l1 = new ArrayList<>();
        l1.add(root.val);
        arr.add(l1);
        while(q.size() > 0){
            List<TreeNode> l = new ArrayList<>();
            while(q.size() > 0){
                TreeNode node = q.remove();
                if(node.left != null)
                    l.add(node.left);
                if(node.right != null)l.add(node.right);
            }
            for(int i = 0; i < l.size(); i++){
                q.add(l.get(i));
            }
            ArrayList<Integer> l2 = new ArrayList<>();
            for(int i =0; i < l.size(); i++){
                l2.add((l.get(i)).val);
            }
            if(l2.size() > 0)
            arr.add(l2);
        }
        return arr;
    }
}