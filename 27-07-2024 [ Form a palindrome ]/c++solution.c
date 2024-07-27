class Solution{
  public:
   int dp[500][500];
    int fun(string str, int i, int j){
        if(i>=j){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int ans=INT_MAX;
        if(str[i]==str[j]){ans=fun(str, i+1, j-1);}
        else{ans=min(fun(str, i+1, j)+1, fun(str, i, j-1)+1);}
        return dp[i][j]=ans;
    }
    int countMin(string str){
      memset(dp, -1, sizeof(dp));
      return fun(str, 0, str.size()-1);
    }
};
