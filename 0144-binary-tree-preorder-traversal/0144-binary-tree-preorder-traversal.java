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
        int  state=1;
        TreeNode root;
        Pair(TreeNode root){
            this.root = root;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        if(root != null)st.push(new Pair(root));
        while(st.size() > 0){
            Pair node = st.peek();
            if(node.state == 1){
                preorder.add(node.root.val);
                st.peek().state++;
                if(node.root.left != null){
                    st.push(new Pair(node.root.left));
                }
            }
            else if(node.state == 2){
                st.peek().state++;
                if(node.root.right != null){
                    st.push(new Pair(node.root.right));
                }
            }
            else{
                st.pop();
            }
        }
        return preorder;
    }
}