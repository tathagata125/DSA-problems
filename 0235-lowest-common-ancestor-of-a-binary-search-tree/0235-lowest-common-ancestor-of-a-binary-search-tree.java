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
    void search(TreeNode root, TreeNode p, ArrayList<TreeNode>arr1){
        if(root == p){
            arr1.add(root);
            return;
        }
        arr1.add(root);
        if(p.val > root.val){
            search(root.right, p, arr1);
        }
        else if(p.val < root.val){
            search(root.left, p, arr1);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode>arr1 = new ArrayList<>();
        ArrayList<TreeNode>arr2 = new ArrayList<>();
        search(root,p, arr1);
        search(root,q,arr2);
        int i = 0;
        while(i < arr1.size() && i < arr2.size() && arr1.get(i) == arr2.get(i)){
            i++;
        }
        return arr1.get(i-1);
    }
}