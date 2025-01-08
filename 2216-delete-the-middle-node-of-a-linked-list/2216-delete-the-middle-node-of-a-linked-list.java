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
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode first = head;
        ListNode second = head;
        ListNode prev = first;
        while(second != null && second.next != null){
            prev = first;
                second = second.next.next;
            
                
            first = first.next;
            
        }
        return prev;
    }
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev = middleNode(head);
        if(head == null || head.next == null){
            return null;
        }
        prev.next = prev.next.next;
        return head;
    }
}