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
    int dfs(Node root){
        if(root == null)return 0;
        int height = 0;
        for(Node childs : root.children){
            height = Math.max(height,dfs(childs));
        }
        return 1+ height;
    }
    public int maxDepth(Node root) {
        return dfs(root);
    }
}