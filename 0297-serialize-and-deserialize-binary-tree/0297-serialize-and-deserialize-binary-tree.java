/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String dfs(TreeNode root){
        if(root == null){
            
            return "n,";
        }
        
        String ans = root.val + ",";
        ans += dfs(root.left);
        ans += dfs(root.right);
        return ans;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "n";
        String data = dfs(root);
        
        System.out.println(data);
        return data;
        
    }
    int idx = 0;
    TreeNode dfs(String[] data){
        if(data[idx].equals( "n")){
            idx++;
            return null;
        }
        
        
        TreeNode node = new TreeNode(Integer.parseInt(data[idx++]));
        node.left = dfs(data);
        node.right = dfs(data);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        
        return dfs(d);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));