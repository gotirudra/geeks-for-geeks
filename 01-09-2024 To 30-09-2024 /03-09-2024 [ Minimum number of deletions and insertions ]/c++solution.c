
class Solution{
public:
  int solve(int i, int j, string& s1, string& s2, vector<vector<int>>&dp){
      if(i >= s1.size()){
          return s2.size()-j;
      }
      if(j >= s2.size()){
          return s1.size()-i;
      }
      if(dp[i][j] != -1){
          return dp[i][j];
      }
      if(s1[i]== s2[j]){
          return solve(i+1, j+1, s1, s2, dp);
      }
      
      int del = 1 + solve(i+1, j, s1, s2, dp);
      
      int ins = 1 + solve(i, j+1, s1, s2, dp);
      
      return dp[i][j] = min(del, ins);
      
  }
  int minOperations(string str1, string str2) 
  { 
     vector<vector<int>>dp(str1.size(), vector<int>(str2.size(), -1));
    return solve(0,0,str1, str2, dp);
      
  } 
};
