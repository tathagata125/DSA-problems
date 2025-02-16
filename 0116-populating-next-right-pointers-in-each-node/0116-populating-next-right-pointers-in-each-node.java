/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node>q = new ArrayDeque<>();
        if(root == null)return root;
        q.add(root);
        while(q.size() > 0){
            int size = q.size();
            Node node = null;
            for(int i = 0; i < size; i++){
                 node = q.remove();
                if(q.size() > 0)node.next = q.peek();
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            node.next = null;
        }
        return root;
    }
}