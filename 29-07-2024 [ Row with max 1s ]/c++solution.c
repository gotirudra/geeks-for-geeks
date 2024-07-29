class Solution {
  public:
    int rowWithMax1s(vector<vector<int> > arr) {
        // code here
        int n=arr.size();
        int m=arr[0].size();
    
        int ans=-1;
        int k=m;
        
        for(int i=0;i<n;i++){
            int j;
            for(j=k-1;j>=0;j--){
                if(arr[i][j]==0){
                    if(k>(j+1)){
                        k=j+1;
                        ans=i;
                        // break;
                    }
                    break;    
                }
                    
            }
            if(j<0)
                return i;
        }
        
        return ans;
    }
};
