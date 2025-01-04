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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(Integer.MAX_VALUE);
        ListNode tail = prev;
        ListNode curr = head;
        

        while(curr != null){
            if(curr.val != tail.val ){
                tail.next = curr;
                tail = curr;
                
            }
            curr = curr.next;
        }
        
        tail.next = null;
        prev = prev.next;
        return prev;
        
    }
}