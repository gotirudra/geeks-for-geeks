class Solution {
public:
    std::string printString(const std::string& s, char ch, int count) {
        std::string ans;
        
        for (char c : s) {
            if (count <= 0) {
                ans += c;
            }
            if (c == ch) {
                --count;
            }
        }
        
        return ans;
    }
};
