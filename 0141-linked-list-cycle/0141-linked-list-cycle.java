/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        int count = 0;
        if(head == null ||head.next == null  ){
            return false;
        }
        while(first != null && second != null ){
             if(first == second && count != 0)return true;
            first = first.next;
            if(second.next == null)return false;
            second = second.next.next;
            count++;
           
        }
        return false;
    }
}