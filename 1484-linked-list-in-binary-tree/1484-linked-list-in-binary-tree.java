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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Helper function to check if the linked list matches the path in the tree
    boolean checkPath(ListNode head, TreeNode root) {
        if (head == null) return true;  // We've matched all nodes in the list
        if (root == null) return false; // Tree node is null but list is not matched
        
        // If the current tree node matches the current linked list node
        if (root.val == head.val) {
            // Recursively check the left and right subtrees
            return checkPath(head.next, root.left) || checkPath(head.next, root.right);
        }
        
        // If the values don't match, return false
        return false;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false; // Empty tree case

        // Try the path starting from the current node
        if (checkPath(head, root)) return true;
        
        // Otherwise, recursively check the left and right subtrees
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
