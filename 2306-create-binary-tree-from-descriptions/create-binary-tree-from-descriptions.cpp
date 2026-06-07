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
class Solution{
public:
    TreeNode *createBinaryTree(vector<vector<int>> &d){
        map<int, TreeNode *> mp;
        unordered_set<int> child;
        for(auto it: d){
            int p=it[0];
            int c=it[1];
            int l=it[2];

            if(!mp.count(p)){
                mp[p]=new TreeNode(p);
            }
            if(!mp.count(c)){
                mp[c]=new TreeNode(c);
            }

            if(l == 1){
                mp[p]->left=mp[c];
            }   
            else{
                mp[p]->right=mp[c];
            }
            child.insert(c);
        }

        for(auto it: d){
            if(child.find(it[0]) == child.end())
                return mp[it[0]];
        }

        return NULL;
    }
};















