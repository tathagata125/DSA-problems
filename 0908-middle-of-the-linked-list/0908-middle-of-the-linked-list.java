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
        if(head.next.next == null){
            return head.next;
        }
        ListNode first = head;
        ListNode second = head;
        while(second != null){
            if(second.next != null)
                second = second.next.next;
            else{
                return first;
            }
            first = first.next;
            
        }
        return first;
    }
}