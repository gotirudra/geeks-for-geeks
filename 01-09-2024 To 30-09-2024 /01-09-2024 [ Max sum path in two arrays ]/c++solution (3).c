class Solution {
  public:
    int maxPathSum(vector<int> &arr1, vector<int> &arr2) {
     
        int n=arr1.size(),m=arr2.size();
       
        int i=0,j=0;
        int ans=0;
          int sum1=0,sum2=0;
          bool flag=false;
      while(i<n && j<m){
         
     
         if(arr1[i]<arr2[j]){
             sum1+=arr1[i];
             i++;
         }
         else if(arr1[i]>arr2[j]){
             sum2+=arr2[j];
             j++;
         }
         else{
             ans+=max(sum1,sum2)+arr1[i];
         
             sum1=0,sum2=0;
             
             i++,j++;
         }
      }
    
       while(i<n) sum1+=arr1[i],i++;
       while(j<m) sum2+=arr2[j],j++;
     
       
      ans+=max(sum1,sum2);
      return ans;
    }
};
