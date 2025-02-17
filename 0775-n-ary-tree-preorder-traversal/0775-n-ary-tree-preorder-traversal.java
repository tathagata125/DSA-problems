/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> l;
    void dfs(Node root){
        
        l.add(root.val);
        for(Node n : root.children){
            dfs(n);
        }
        
    }
    public List<Integer> preorder(Node root) {
        l = new ArrayList<>();
        if(root != null)dfs(root);
        return l;
    }
}