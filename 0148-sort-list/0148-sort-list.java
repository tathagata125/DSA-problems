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
        ListNode prev=null ;
        while(second != null && second.next != null){
            prev = first;
            first = first.next;
            second = second.next.next;
            
        }
        prev.next = null;
        return first;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
                
            }
            else{
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
                
            }
        }
        if(list1 != null)tail.next = list1;
        else {
            tail.next = list2;

        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
       ListNode mid = middleNode(head);
       ListNode l1 = sortList(head);
       ListNode l2 = sortList(mid);
       return mergeTwoLists(l1,l2);
    }
}