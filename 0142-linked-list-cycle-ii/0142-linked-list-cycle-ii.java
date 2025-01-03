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
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        int flag=0;
        
        
        while(second != null && second.next != null ){
            
            first = first.next;
            
            second = second.next.next;
             if(first == second){ 
                flag = 1;
              break;
             }
           
        }
        if(flag == 0){return null;}
        while(head != second){
            head=head.next;
            second = second.next;
           
        }
        return second;
    }
}