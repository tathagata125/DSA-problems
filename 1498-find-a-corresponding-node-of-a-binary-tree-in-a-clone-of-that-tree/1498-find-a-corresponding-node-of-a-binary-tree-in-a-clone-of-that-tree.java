/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null)return null;
        if(original == target && original.val == cloned.val)return cloned;
        TreeNode nodeL = getTargetCopy(original.left,cloned.left,target);
        TreeNode nodeR = getTargetCopy(original.right,cloned.right,target);
        if(nodeL != null)return nodeL;
        return nodeR;
    }
}