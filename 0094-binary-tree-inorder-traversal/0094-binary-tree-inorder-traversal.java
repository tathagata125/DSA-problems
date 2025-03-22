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
        int state = 1;
        TreeNode root;
        Pair(TreeNode root){
            this.root = root;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        if(root != null)st.push(new Pair(root));
        while(st.size() > 0){
            Pair node = st.peek();
            if(node.state ==1){
                st.peek().state++;
                if(node.root.left != null){
                    st.push(new Pair(node.root.left));
                }
            }
            else if(node.state == 2){
                inorder.add(node.root.val);
                st.peek().state++;
                if(node.root.right != null){
                    st.push(new Pair(node.root.right));
                }
            }
            else{
                st.pop();
            }
        }
        return inorder;
    }
}