/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void addNode(TreeNode* root, int val){
        if(val < root->val){
            if(root->left){
                addNode(root->left,val);
            }
            else{
                TreeNode* newnode = new TreeNode(val);
                root->left = newnode;
            }
        }
        else{
            if(root->right){
                addNode(root->right,val);
            }
            else{
                TreeNode* newnode = new TreeNode(val);
                root->right = newnode;
            }
        }

    }
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if(root == NULL){
            TreeNode *newnode = new TreeNode(val);
            return newnode;
        }
        addNode(root, val);
        return root;
    }
};