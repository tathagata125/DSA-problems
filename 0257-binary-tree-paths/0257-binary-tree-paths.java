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
    ArrayList<String> arr;
    void traverse(TreeNode root, String s){
        if(root == null){
            return ;
        }
        if(root.left ==null && root.right == null){
            String str = Integer.toString(root.val);
            if(s == ""){
            arr.add(s+str);
            }
            else{
            arr.add(s+"-"+">"+str);
            return;
            }
        }
        String str = Integer.toString(root.val);
        if(s == ""){
            traverse(root.left,s+str);
            traverse(root.right,s+str);
        }
        else{
            traverse(root.left,s+"-"+">"+str);
            traverse(root.right,s+"-"+">"+str);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        arr = new ArrayList<>();
        traverse(root,"");
        return arr;
    }
}