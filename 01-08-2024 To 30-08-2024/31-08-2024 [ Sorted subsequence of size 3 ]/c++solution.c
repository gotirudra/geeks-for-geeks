
class Solution {
  public:
    bool f(int i, int prev, int limit, vector<int> &arr, vector<int> &ans) {
    if (limit == 0) return true; 
    if (i == arr.size()) return false;

    if (f(i + 1, prev, limit, arr, ans)) return true;


    if (prev == -1 || arr[prev] < arr[i]) {
        ans.push_back(arr[i]);
        if (f(i + 1, i, limit - 1, arr, ans)) return true;
        ans.pop_back(); 
    }

    return false;
}

vector<int> find3Numbers(vector<int> &arr) {
    vector<int> ans;
    
    if (f(0, -1, 3, arr, ans)) {
       
        return ans;
    } else {
        return {};
    }
}

};
