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
    ListNode handler(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = left + (right- left)/2;
        ListNode l1 = handler(lists, left, mid);
        ListNode l2 = handler(lists, mid + 1, right);
        return mergeTwoLists(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return handler(lists,0, lists.length - 1);
    }
}