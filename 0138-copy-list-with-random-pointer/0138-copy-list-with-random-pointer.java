/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copy = new Node(-1);
        Node tail = copy;
        Node tailh = head;
        HashMap<Node,Node>mirror = new HashMap<>();
        while(tailh != null){
            Node n = new Node(tailh.val);
            mirror.put(tailh,n);
            tail.next = n;
            tail=tail.next;
            tailh = tailh.next;

        }
        tailh = head; tail = copy.next;
        while(tailh != null){
            tail.random = mirror.get(tailh.random);
            tail=tail.next;
            tailh=tailh.next;
        }
        return copy.next;
    }
}