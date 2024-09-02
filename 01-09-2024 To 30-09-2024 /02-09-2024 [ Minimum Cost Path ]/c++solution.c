class Solution {
    public:
  int dr[4] = {1,-1,0,0};
  int dc[4] = {0,0,1,-1};
    int minimumCostPath(vector<vector<int>>& v) {
        int n=v.size(), m=v[0].size();
        vector<vector<int>> dist(n, vector<int> (m, 1e9));
        
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> q;
        q.push({v[0][0], {0, 0}});
        dist[0][0] = v[0][0];
        
        while(!q.empty()) {
            int w = q.top().first;
            int x = q.top().second.first;
            int y = q.top().second.second;
            q.pop();
            
            for(int k=0;k<4;k++) {
                int i = x+dr[k];
                int j = y+dc[k];
                
                if(i>=0 && j>=0 && i<n && j<m && dist[i][j]> w + v[i][j]) {
                    dist[i][j] =  w+ v[i][j];
                    q.push({dist[i][j], {i, j}});
                }
            }
        }
        return dist[n-1][m-1];
    }
};
