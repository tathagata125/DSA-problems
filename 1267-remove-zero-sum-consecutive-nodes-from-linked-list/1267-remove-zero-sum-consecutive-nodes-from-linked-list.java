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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        int prefix = 0;
        HashMap<Integer,ListNode> m = new HashMap<>();
        dummy.next = head ;
        m.put(0,dummy);
        while(curr != null){
            prefix += curr.val;
            if(m.containsKey(prefix)){
                ListNode start = m.get(prefix);
                ListNode temp = start;
                int sum = prefix;
                while(temp != curr){
                    temp = temp.next;
                    sum += temp.val;
                    if(temp != curr){
                        m.remove(sum);
                    }
                }
                start.next = curr.next;
            }
            else{
                m.put(prefix,curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}