class Solution {
  public:
  Node* sortedArrayToBST(vector<int>& nums) {
        // Code here
        int s=0;
        int e=nums.size()-1;
        return newBST(nums,s,e);
    }
    
    Node* newBST(vector<int>& nums,int s,int e){
        
        if(s>e){
            return nullptr;
        }
        int mid=s+(e-s)/2;
        Node* root=new Node(nums[mid]);
        root->left=newBST(nums,s,mid-1);
        root->right=newBST(nums,mid+1,e);
        return root;
    }
};
