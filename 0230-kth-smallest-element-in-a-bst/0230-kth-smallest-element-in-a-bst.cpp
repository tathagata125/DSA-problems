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
    void kSmallest(TreeNode* root, priority_queue<int>& q){
        q.push(-(root->val));
        if(root->left)
        kSmallest(root->left,q);
        if(root->right)
        kSmallest(root->right,q);

    }
    int kthSmallest(TreeNode* root, int k) {
        priority_queue<int>q;
        kSmallest(root,q);
        for(int i =0;i<k-1;i++){
            q.pop();
        }
        return -q.top();
    }
};