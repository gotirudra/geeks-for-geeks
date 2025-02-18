class Solution {
  public:
    long long maxSubarraySum(vector<int> &arr) {
       
        long long ans = INT_MIN;
        long long curr = 0;
        for(auto val:arr){
            curr += val;
            ans = max(curr,ans);
            if(curr < 0){
                curr = 0;
            }
        }
        return ans;
    }
    
};
