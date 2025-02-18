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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> l = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        if(root == null)return l;
        q.add(root);
        while(q.size() > 0){
            int size = q.size();
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = q.remove();
                
                arr.add(node.val);
                for(Node no : node.children){
                    q.add(no);
                }

            }
            l.add(arr);
        }
        return l;
    }
}