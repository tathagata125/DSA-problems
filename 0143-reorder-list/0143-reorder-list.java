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
            first = first.next;
            second=second.next.next;
            
        }
        return prev;
    }
    public ListNode reverseList(ListNode head) {
         ListNode prev = null,  curr = head;
         while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
         }
         head = prev;
         return head;
    }
    public void reorderList(ListNode head) {
       ListNode mid = middleNode(head);

        
        ListNode right = reverseList(mid.next);
        mid.next = null;
       
        ListNode left = head;
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(left != null || right != null){
           
           if(left != null){
            tail.next = left;
            left = left.next;
            tail = tail.next;
           }
           if(right != null){
            tail.next = right;
            right = right.next;
            tail=tail.next;
           }
        }
        
        
    }
}
