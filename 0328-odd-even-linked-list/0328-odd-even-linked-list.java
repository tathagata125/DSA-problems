/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyE = new ListNode(-1);
        ListNode tailE = dummyE;
        ListNode dummyO = new ListNode(-1);
        ListNode tailO = dummyO;
        while(head != null){
            tailO.next = head;
            tailO = tailO.next;
            head=head.next;
            if(head != null){
                tailE.next = head;
                tailE = tailE.next;
                head = head.next;
            }
        }
        tailO.next = dummyE.next;
        tailE.next = null;
        return dummyO.next;
        
    }
}