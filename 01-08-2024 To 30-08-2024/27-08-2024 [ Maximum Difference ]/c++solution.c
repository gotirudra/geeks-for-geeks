

class Solution {
  public:
   
    int findMaxDiff(vector<int> &arr) {
    vector<int> ls, rs;

        for(int i=0; i<arr.size(); i++){
            if(i == 0){
                ls.push_back(0);
            }else{
               
                bool flag = false;
                for(int j=i-1; j>=0; j--){
                    if(arr[j] < arr[i]){
                        ls.push_back(arr[j]);
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    ls.push_back(0);
                }
            }
    
            if(i == arr.size()-1){
                rs.push_back(0);
            }else{
                
                bool flag = false;
                for(int j=i+1; j<arr.size(); j++){
                    if(arr[j] < arr[i]){
                        rs.push_back(arr[j]);
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    rs.push_back(0);
                }
            }
        }
        
        int maxDiff=0;
        for(int i=0; i<ls.size(); i++){
            maxDiff = max(maxDiff, abs(ls[i] - rs[i]));
        }
        return maxDiff;    
    }
};
