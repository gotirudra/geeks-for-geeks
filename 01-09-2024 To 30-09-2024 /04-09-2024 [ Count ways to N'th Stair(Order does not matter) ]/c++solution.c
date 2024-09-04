
class Solution{
  public:
  int nthStair(int n){
         
            int ans = 1;
            while(n>1)
            {
                ans++;
                n -= 2;
            }
            return ans;
        }
};
