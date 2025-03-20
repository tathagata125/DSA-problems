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
    TreeNode dvc(int[] nums, int low, int high){
        if(low > high)return null;
        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dvc(nums,low, mid-1);
        node.right = dvc(nums, mid + 1, high);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return dvc(nums, 0, nums.length-1);
    }
}