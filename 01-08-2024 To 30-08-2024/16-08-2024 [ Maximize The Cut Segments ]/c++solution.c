class Solution
{
    public:
 
   
    int f(int n, int x, int y, int z,int sum,vector<int>& dp){
        if(sum==n){return 0;}
        if(sum>n){return INT_MIN;}
        if(dp[sum]!=-1){return dp[sum];}
     
       else{
        int one=1+f(n,x,y,z,sum+x,dp);
        int two=1+f(n,x,y,z,sum+y,dp);
        int three=1+f(n,x,y,z,sum+z,dp);
        
        return dp[sum]=max(one,max(two,three));
     }
        
    }
    int maximizeTheCuts(int n, int x, int y, int z)
    {
      
        vector<int> dp(n+1,-1);
        int ans=f(n,x,y,z,0,dp);
        if(ans<0){return 0;}
        return ans;
    }
};
