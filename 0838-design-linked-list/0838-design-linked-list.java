// Design Singly Linked List: LC 707
// https://leetcode.com/problems/design-linked-list/description/

class ListNode {
    int val;
    ListNode prev; 
    ListNode next;
}

class MyLinkedList {
    ListNode head, tail;
    int size = 0;

    public ListNode getNode(int index) {
        if (index < 0 || index >= size)
            return null;

        ListNode curr = head;
        for (int idx = 0; idx < index; idx++) {
            curr = curr.next;
        }
        return curr;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        return getNode(index).val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode();
        node.val = val;
        size++;

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode();
        node.val = val;
        size++;

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode node = new ListNode();
        node.val = val;
        ListNode pre = getNode(index - 1);
        size++;
        node.next = pre.next;
        node.prev = pre;
        pre.next = node;
        node.next.prev = node;
    }
    public void deleteTail(){
        size -- ;
        if(size == 0){
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        

        if (index == 0) {
            // delete head node
            size--;
            if(size == 0){
                head = tail = null;
                return;
            }
            else{
            head = head.next;
            head.prev = null;
            return;
            }
        }
        else if(index == size - 1){
            deleteTail();
            return;
        }
        size--;
        ListNode node = getNode(index );
        node.prev.next = node.next;
        node.next.prev = node.prev;

        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */