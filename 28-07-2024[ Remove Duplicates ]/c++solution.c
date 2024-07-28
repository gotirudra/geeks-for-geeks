class Solution {
  public:

    string removeDups(string str) {
        int v=str.length();
        string ans="";
        
        unordered_map<char,int> mp;
        
        for(int i=0;i<v;i++){
            if(mp.find(str[i])==mp.end()){
                ans+=str[i];
                mp[str[i]]++;
            }
        }
        return ans;;
        // Your code goes here
    }
};
