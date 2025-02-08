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
    ArrayList<ArrayList<TreeNode>> list ;
    void dfs(TreeNode root, TreeNode p , ArrayList<TreeNode>output){
        if(root == null)return;
        if(root == p){
            output.add(root);
            list.add(new ArrayList<>(output));
            
            return;
        }
        output.add(root);
        dfs(root.left, p,output);

        
        dfs(root.right, p,output);
        output.remove(output.size()-1);
        

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        list = new ArrayList<>();
        ArrayList<TreeNode> output = new ArrayList<>();
       ArrayList<TreeNode> output1 = new ArrayList<>();
        dfs(root,p,output);
        dfs(root,q,output1);
       
        for(int i = 0; i < list.get(0).size(); i++){
            System.out.print(list.get(0).get(i).val);
        }
        System.out.println();
        for(int j = 0; j < list.get(1).size(); j++){
            System.out.print(list.get(1).get(j).val);
        }
        int i= 0;
        int j= 0;
        while (i < list.get(0).size() && j < list.get(1).size() && list.get(0).get(i).val == list.get(1).get(j).val){

            System.out.println(list.get(0).get(i).val);
            System.out.println(list.get(1).get(j).val);
            i++;
            j++;
        }
        return list.get(0).get(i-1);
    }
}