

class Solution {
public:
    int editDistance(const std::string& str1, const std::string& str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Create a 2D array to store the number of operations
        std::vector<std::vector<int>> dp(m + 1, std::vector<int>(n + 1));
        
        // Fill the dp array
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                // If str1 is empty, we need to insert all characters of str2
                if (i == 0) {
                    dp[i][j] = j;
                }
                // If str2 is empty, we need to remove all characters of str1
                else if (j == 0) {
                    dp[i][j] = i;
                }
                // If last characters are the same, ignore last char and recur for the remaining substring
                else if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If the last character is different, consider all possibilities and find the minimum
                else {
                    dp[i][j] = 1 + std::min(dp[i][j - 1], // Insert
                                            std::min(dp[i - 1][j], // Remove
                                                     dp[i - 1][j - 1])); // Replace
                }
            }
        }
        
        // The result is the number of operations required to convert str1 to str2
        return dp[m][n];
    }
};
