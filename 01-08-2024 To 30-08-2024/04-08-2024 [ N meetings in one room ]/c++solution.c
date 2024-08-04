class Solution {
  public:
  
   int maxMeetings(int n, int start[], int end[]) {
       
        vector<pair<int,int>>timing;
        for(int i=0; i<n; i++){
            timing.push_back({end[i], start[i]});
        }
        sort(timing.begin(),timing.end());
        
        int ans=0, last_metting=-99999;
        for(int i=0 ; i<n; i++){
            int s_time=timing[i].second;
            int e_time= timing[i].first;
            if(s_time > last_metting){
                last_metting= e_time;
                ans++;
            }
        }
        return ans;
    }
};
