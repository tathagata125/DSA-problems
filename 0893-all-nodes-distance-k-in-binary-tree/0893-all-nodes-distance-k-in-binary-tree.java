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
    List<Integer> arr = new ArrayList<>() ;
    void dfs(TreeNode root, int k){
        
        if(k < 0 || root == null)return;
        if(k == 0 )arr.add(root.val);
        dfs(root.left,k-1);
        dfs(root.right, k-1);

    }
    int find(TreeNode root, TreeNode target, int k){
        if(root == null)return -1;
        if(root == target){
            dfs(root, k);
            return 1;
        }
        int left = find(root.left, target, k);
        if(left >= 0){
            dfs(root.right,  k-left-1);
            if(k == left)arr.add(root.val);
            return left+1;
        }
        int right = find(root.right, target, k);
        if(right >= 0 ){
            dfs(root.left,  k-right-1);
                if(k == right)arr.add(root.val);
                return right+1;
            
        }
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find(root, target, k);
        return arr;
    }
}