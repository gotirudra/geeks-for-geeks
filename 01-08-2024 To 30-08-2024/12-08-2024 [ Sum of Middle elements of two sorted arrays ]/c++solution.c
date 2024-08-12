class Solution {
  public:
    int SumofMiddleElements(vector<int> &arr1, vector<int> &arr2) {
      
        int n1=arr1.size();
        int n2=arr2.size();
        int n=n1+n2;

        int ans=0;
        int temp=0;
        int count=n/2+1;
        int i=0, j=0;
        while(count--){
            if(i<n1 && j<n2){
                if(arr1[i]<arr2[j]){
                    temp=ans;
                    ans=arr1[i];
                    i++;
                }
                else{
                    temp=ans;
                    ans=arr2[j];
                    j++;
                }
            }
            else if(i<n1){
                temp=ans;
                ans=arr1[i];
                i++;
            }
            else{
                temp=ans;
                ans=arr2[j];
                j++;
            }
        }
        return ans+temp;
    }
};
