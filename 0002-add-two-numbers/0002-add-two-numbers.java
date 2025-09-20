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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int d1 = l1 != null ? l1.val : 0;
            int d2 = l2 != null ? l2.val : 0;
            ListNode node = new ListNode((d1+d2+carry)%10);
            carry = (d1 + d2 + carry)/10;
            tail.next = node;
            tail = node;
            System.out.println(d1+d2);
            if(l1 != null)l1 = l1.next;
            if(l2 != null)l2 = l2.next;
        }
        if(carry == 1){
            ListNode node = new ListNode(1);
            tail.next = node;
            tail=node;
        }
        tail.next = null;
        return dummy.next;
    }
}