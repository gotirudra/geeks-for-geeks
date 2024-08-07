class Solution {
  public:
   int kthElement(int k, vector<int>& arr1, vector<int>& arr2) {
        // code here
        int s=arr1.size()-1;
        int e=0;
        int n=arr2.size();
        int n1=arr1.size();
        if(k>n1+n) return -1;
        while(s>=0 && e<n)
        {
            if(arr1[s]>arr2[e])
            {
                swap(arr1[s],arr2[e]);
                s--;
                e++;
            }
            else
            {
                break;
            }
        }
        sort(arr1.begin(),arr1.end());
        sort(arr2.begin(),arr2.end());
        if(k<=n1)
        {
            return arr1[k-1];
        }
        k=k-n1;
        return arr2[k-1];
    }
};
