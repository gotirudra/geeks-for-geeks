class Solution {
  public:
    vector <int> bottomView(Node *root) {
       
        vector<int> ans;
        if(root == NULL){
            return ans;
        }
        map<int, int> topNode;
        queue<pair<Node*, int>> q;
        q.push({root, 0});
        while(!q.empty()){
            pair<Node*, int> temp = q.front();
            q.pop();
            auto frontNode = temp.first;
            int hd = temp.second;
            
            topNode[hd] = frontNode->data;
            if(frontNode->left){
                q.push({frontNode->left, hd-1});
            }
            if(frontNode->right){
                q.push({frontNode->right, hd+1});
            }
        }
        for(auto i: topNode){
            ans.push_back(i.second);
        }
        return ans;
    }
};
