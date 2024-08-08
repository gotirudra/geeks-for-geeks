class Solution {
  public:
   bool isSumTree(Node* root) {
        
        if(root==NULL||(root->left==NULL&&root->right==NULL)) return true;
        int left=0,right=0;
        if(root->left) left+=root->left->data;
        if(root->right) right+=root->right->data;
        bool temp=left+right==root->data;
        root->data=left+right+root->data;
        return temp&&isSumTree(root->left)&&isSumTree(root->right);
    }
};
