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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode tail1 = left;
        ListNode right = new ListNode(-1);
        ListNode tail = right;
        while(head != null){
            if(head.val < x){
                tail1.next = head;
                tail1 = tail1.next;
                head = head.next;
            }
            else{
                tail.next = head;
                tail = tail.next;
                head = head.next;
            }
        }
        tail1.next = right.next;
        tail.next = null;
        return left.next;

    }
}