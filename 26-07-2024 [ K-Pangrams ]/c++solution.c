class Solution {
public:
    bool kPangram(const string& str, int k) {
        // Remove spaces from the string
        string filteredStr;
        for (char c : str) {
            if (c >= 'a' && c <= 'z') {
                filteredStr.push_back(c);
            }
        }
        
        // If the length of the filtered string is less than 26, return false
        if (filteredStr.length() < 26) return false;
        
        // Use an unordered_set to track unique characters
        unordered_set<char> uniqueChars;
        
        for (char c : filteredStr) {
            uniqueChars.insert(c);
        }
        
        // Calculate the number of missing characters to make a pangram
        int missingCount = 26 - uniqueChars.size();
        
        // Check if we can cover all missing characters with at most k swaps
        return missingCount <= k;
    }
    
    void test() {
        // Define test cases
        string str1 = "the quick brown fox jumps over the lazy dog";
        int k1 = 0;
        cout << kPangram(str1, k1) << endl; // Expected Output: 1 (true)
        
        string str2 = "aaaaaaaaaaaaaaaaaaaaaaaaaa";
        int k2 = 25;
        cout << kPangram(str2, k2) << endl; // Expected Output: 1 (true)
        
        string str3 = "a b c d e f g h i j k l m";
        int k3 = 20;
        cout << kPangram(str3, k3) << endl; // Expected Output: 0 (false)
        
        // Additional test cases
        string str4 = "a b c d e f g h i j k l m n o p";
        int k4 = 20;
        cout << kPangram(str4, k4) << endl; // Expected Output: 0 (false)

        string str5 = "abcdefghijklmnopqrstuvwxyz";
        int k5 = 0;
        cout << kPangram(str5, k5) << endl; // Expected Output: 1 (true)
    }
};
