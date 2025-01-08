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
    int size(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int n = size(head);
        while(curr != null){
            if( n < k){
                tail.next = curr;
                break;
            }
            n-=k;
            ListNode groupH = new ListNode(-1);
            ListNode groupT = groupH;
            for(int i = 0; i<k ; i++){
                groupT.next = curr;
                curr = curr.next;
                groupT= groupT.next;
            }
            groupT.next = null;
            tail.next = reverse(groupH.next);
            tail = groupH.next;
        }
        return dummy.next;
    }
}