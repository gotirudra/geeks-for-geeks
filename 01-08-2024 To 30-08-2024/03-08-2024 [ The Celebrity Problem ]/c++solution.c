class Solution {
public:
    int celebrity(vector<vector<int> >& mat) {
        int n = mat.size();
        int candidate = 0;
        
        // Find a candidate
        for(int i = 1; i < n; i++) {
            if(mat[candidate][i] == 1) {
                candidate = i;
            }
        }
        
        // Verify the candidate
        for(int i = 0; i < n; i++) {
            if(i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }
        
        return candidate;
    }
};
