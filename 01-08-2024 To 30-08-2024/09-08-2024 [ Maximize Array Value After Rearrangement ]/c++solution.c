class Solution {
  public:
  #define mod 1000000007
  public:
    int Maximize(vector<int> arr) {
        sort(arr.begin(), arr.end());
        long sum =0;
        
        for(int i =0; i<arr.size(); i++){
            sum += (long)arr[i]*i;
        }
        long ans = sum%mod;
        return (int)ans;
    }
};
